package io.quarkus.deployment.builditem;

import java.io.Closeable;

public interface Startable extends Closeable {
    void start();

    String getConnectionInfo();

    // This starts to couple to containers, so we could move it to sub-interface and use that in dev services
    String getContainerId();

    /**
     * @return {@code true} if this is configured for Testcontainers-level reuse, in which case it must
     *         survive being {@link #close() closed} by Quarkus, so a later, separate JVM run can reuse it.
     */
    default boolean isReusable() {
        return false;
    }

}
