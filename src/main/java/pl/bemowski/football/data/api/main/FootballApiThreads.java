package pl.bemowski.football.data.api.main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by kamil on 18.02.17.
 */
class FootballApiThreads {

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    private FootballApiThreads() {

    }

    public static FootballApiThreads instance() {
        return FootballApiThreadsHolder.threads;
    }

    public ScheduledFuture<?> schedule(final Runnable runnable, final long period, final TimeUnit unit) {
        return scheduledExecutorService.scheduleAtFixedRate(runnable, 0, period, unit);
    }

    public void schedule() {
    }

    private static final class FootballApiThreadsHolder {
        static final FootballApiThreads threads = new FootballApiThreads();
    }
}
