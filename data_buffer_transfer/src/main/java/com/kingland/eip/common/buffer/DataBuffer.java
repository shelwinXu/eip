/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.common.buffer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import static com.kingland.eip.common.Consts.MAX_TIMEOUT;

/**
 * This class is define a buffer
 * @param <T>
 */
public class DataBuffer<T> {
    private int capacity;

    private ConcurrentLinkedQueue<T> buffer = new ConcurrentLinkedQueue <T>();

    private DataBufferStatus status;

    public DataBuffer(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("The buffer capacity must be larger than 0." );
        }
        this.capacity = capacity;
        this.status = DataBufferStatus.Active;
    }

    /**
     * this function can enqueue data
     * @param dataList
     * @throws Exception
     */
    public void enqueue(List<T> dataList) throws Exception {
        synchronized (this){
            if (status != DataBufferStatus.Active) {
                throw new Exception("[enqueue] No more data can be enqueued, as the buffer status is: " + status);
            }

            for (T data : dataList) {
                if(buffer.size() == capacity) {
                   System.out.println("[enqueue] The buffer is full, waiting for new space...");
                   this.wait(MAX_TIMEOUT);
                }
                buffer.add(data);
            }
            this.notifyAll();
        }
    }

    /**
     * this function can dequeue data
     * @param count
     * @return
     * @throws Exception
     */
    public List <T> dequeue(int count) throws Exception {
        List <T> result = new ArrayList<T>();
        synchronized (this){
            while (buffer.isEmpty()){
                System.out.println("The buffer is empty, waiting for new data input...");
                this.wait(MAX_TIMEOUT);
                return result;
            }

            while (result.size() < count && !buffer.isEmpty()){
                result.add(buffer.poll());
            }
            this.notifyAll();
            return result;
        }

    }

    public DataBufferStatus getStatus() {
        return status;
    }

    public void setStatus(DataBufferStatus value) throws Exception {
        // The buffer status cannot be changed back to Active if it's not Active.
        if (status != DataBufferStatus.Active && value == DataBufferStatus.Active) {
            System.out.println( "The buffer status cannot be changed back to Active if it's not Active." );
            return;
        }

        switch (value) {
            case Active:
                status = value;
                break;
            case EnqueueCompleted:
            case EnqueueError:
                status = value;
                break;
            case DequeueCompleted:
            case DequeueError:
                status = value;
                break;
            default:
                throw new Exception( "Unexpected value of buffer status: " + value );
        }
        System.out.println( "Set buffer status to: " + value );
    }
}
