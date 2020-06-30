package com.leafclient.trunk.utility

import java.time.Duration
import java.time.Instant

/**
 * Allows developers to check whether a certain time amount has been reached
 */
data class Delayer(private var startInstant: Instant = Instant.now()) {

    /**
     * Reset the [startInstant] to now.
     */
    fun reset() = apply {
        startInstant = Instant.now()
    }

    /**
     * Checks whether this [Delayer] has reached [duration]
     */
    fun hasReached(duration: Duration)
            = Instant.now()
            .minus(duration)
            .isAfter(startInstant)

    /**
     * Runs [lambda] and [Delayer.reset] if [duration] has been reached by
     * this [Delayer].
     */
    inline fun ifReached(duration: Duration, crossinline lambda: () -> Unit) {
        if(hasReached(duration)) {
            lambda()
            reset()
        }
    }

}