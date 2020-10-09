package com.kingland.eip.data_transfer;//package com.kingland.eip.data_transfer;
//
//import com.kingland.eip.common.buffer.DataBuffer;
//import com.kingland.eip.common.buffer.DataBufferStatus;
//import com.kingland.eip.data_transfer.function.DataLoader;
//import com.kingland.eip.data_transfer.function.DataSendFun;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DataTransfer<T> {
//    /**
//     * The count of data that will be loaded from data source in a batch.
//     */
//    private int loadBatchSize;
//
//    /**
//     * The count that how many data will be seeded in a batch, which means in a single request to the ESB service.
//     */
//    private int seedBatchSize;
//
//    /**
//     * The buffer size, The Data Load thread will populate the data to the buffer, and the Data Seed thread will fetch data from the buffer.
//     */
//    private int bufferSize;
//
//    /**
//     * The delegate method to load data in batch.
//     */
//    private DataLoader loadData;
//
//    /**
//     * The delegate method to send data in batch.
//     */
//    private DataSendFun<T> sendData;
//
//    public DataTransfer(int loadBatchSize,
//                        int seedBatchSize,
//                        int bufferSize,
//                        DataLoader loadData,
//                        DataSendFun<T> sendData) {
//        this.loadBatchSize = loadBatchSize;
//        this.seedBatchSize = seedBatchSize;
//        this.bufferSize = bufferSize;
//        this.loadData = loadData;
//        this.sendData = sendData;
//    }
//
//    /**
//     * Default Constructor
//     */
//    public DataTransfer(DataLoader loadData, DataSendFun<T> sendData){
//        this(2000,10000,1024,loadData,sendData);
//    }
//
//    /**
//     * Seed the data.
//     */
//    public void start() throws Exception {
//        Thread loadThread = null;
//        DataBuffer<T> buffer = new DataBuffer<T>(bufferSize);
//
//        try {
//            // Load the data, and populate the data to the buffer by a new thread.
//            loadThread = loadData(buffer);
//
//            // Send the data in current thread
//            sendData(buffer);
//        } finally {
//            // Wait for data load thread to exit if any unexpected error occurs
//            if (loadThread != null && loadThread.isAlive()) {
//                try {
//                    System.out.println("Waiting for data load thread to exit...");
//                    loadThread.join(10 * 60 * 1000);
//                    System.out.println("Stop waiting for data load thread to exit, alive: " + loadThread.isAlive());
//                } catch (Throwable ex) {
//                    System.out.println("Error occurred while waiting for data load thread to exit");
//                }
//            }
//        }
//    }
//
//    /**
//     * Load the data, and populate the data to the by a new thread.
//     * @return The thread to load data
//     */
//    public Thread loadData(DataBuffer <T> buffer) {
//        Thread mainThread = Thread.currentThread();
//
//        Thread loadDataThread = new Thread( () -> {
//            // Set the tread name based on the main thread name
//            //ThreadUtility.setThreadName(mainThread);
//            Thread.currentThread().setName("First 1");
//            int totalCnt = 0;
//            //StopWatch sw = new StopWatch();
//            //sw.start( "Load data" );
//            System.out.println("Start load data");
//            try {
//                //triggerEvent( loadStartingHandler, null );
//
//                boolean hasDataLeft = false;
//                do {
//                    List <T> dataList = loadData.apply( loadBatchSize);
//                    if (dataList == null) {
//                        dataList = new ArrayList<>();
//                    }
//                    buffer.enqueue( dataList );
//
//                    totalCnt += dataList.size();
//                    hasDataLeft = (dataList.size() > 0);
//                }
//                while (hasDataLeft);
//
//                buffer.setStatus( DataBufferStatus.EnqueueCompleted );
//                //sw.stop();
//
//                //triggerEvent( loadCompletedHandler, new DataTransferEventArgs( totalCnt, sw.getTotalTimeSpent(), buffer.getEnqueueWaitTime() ) );
//            } catch (Throwable ex) {
//                try {
//                    buffer.setStatus( DataBufferStatus.EnqueueError );
//                    //triggerEvent( loadErrorHandler, new DataTransferEventArgs( ex ) );
//                } catch (Exception internalEx) {
//                    System.out.println( "Error occurred while updating the buffer status to EnqueueError.");
//                }
//            } finally {
//                //sw.reset();
//                //ThreadUtility.resetThreadName();
//            }
//        } );
//
//        loadDataThread.start();
//        return loadDataThread;
//    }
//
//    /**
//     * Send the data which will be retrieved from the buffer
//     *
//     * @param buffer The buffer to store the data.
//     */
//    public void sendData(DataBuffer <T> buffer) throws Exception {
//        int totalCnt = 0;
//        //StopWatch sw = new StopWatch();
//        //sw.start( "start to send data" );
//
//        try {
//            //triggerEvent( sendStartingHandler, null );
//
//            boolean completed = false;
//            do {
//                List<T> dataList = buffer.dequeue( seedBatchSize );
//                totalCnt += dataList.size();
//
//                if (dataList.size() > 0) {
//                    // Send the data.
//                    sendData.execute(dataList);
//
//                } else {
//                    // No more data can be sent.
//                    if (buffer.getStatus() != DataBufferStatus.Active) {
//                        completed = true;
//                    } else {
//                        System.out.println( "No data can be dequeued from the active buffer, try again..." );
//                    }
//                }
//            }
//            while (!completed);
//
//            buffer.setStatus( DataBufferStatus.DequeueCompleted );
//            //sw.stop();
//
//            //triggerEvent( sendCompleteHandler, new DataTransferEventArgs( totalCnt, sw.getTotalTimeSpent(), buffer.getDequeueWaitTime() ) );
//        } catch (Throwable ex) {
//            buffer.setStatus( DataBufferStatus.DequeueError );
//            //triggerEvent( sendErrorHandler, new DataTransferEventArgs( ex ) );
//        } finally {
//            //sw.reset();
//        }
//    }
//}