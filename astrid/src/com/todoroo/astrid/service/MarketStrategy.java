package com.todoroo.astrid.service;

import android.content.Intent;
import android.net.Uri;

public abstract class MarketStrategy {

    /**
     * @param packageName
     * @return an intent to launch market with this package
     */
    abstract public Intent generateMarketLink(String packageName);

    /**
     * @return if this market has power pack
     */
    public boolean includesPowerPack() {
        return true;
    }

    /**
     * @return if this market has locale plugin
     */
    public boolean includesLocalePlugin() {
        return true;
    }

    /**
     * @return true if addons should be shown
     */
    public boolean showAddonMenu() {
        return true;
    }

    public static class AndroidMarketStrategy extends MarketStrategy {

        @Override
        public Intent generateMarketLink(String packageName) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://search?q=pname:" + //$NON-NLS-1$
                            packageName));
        }

    }

    public static class AmazonMarketStrategy extends MarketStrategy {

        @Override
        public Intent generateMarketLink(String packageName) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.amazon.com/gp/mas/dl/android?p=" + //$NON-NLS-1$
                            packageName));
        }

        @Override
        public boolean includesLocalePlugin() {
            return false;
        }

    }

}
