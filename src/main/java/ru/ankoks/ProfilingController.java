package ru.ankoks;

/**
 * User: ankoks
 * Date: 26.09.2018
 */
public class ProfilingController implements ProfilingControllerMBean {
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
