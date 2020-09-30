/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.common.buffer;

public enum DataBufferStatus {
    /**
     * The default status, means the buffer is active to enqueue and dequeue.
     */
    Active,

    /**
     * Data enqueue has been completed, no more data will be enqueued any more.
     */
    EnqueueCompleted,

    /**
     * Data dequeue has been completed, no more data will be dequeued any more.
     */
    DequeueCompleted,

    /**
     * Error occurred while enqueuing data, no more data will be enqueued any more.
     */
    EnqueueError,

    /**
     * Error occurred while enqueuing data, no more data will be enqueued any more.
     */
    DequeueError
}