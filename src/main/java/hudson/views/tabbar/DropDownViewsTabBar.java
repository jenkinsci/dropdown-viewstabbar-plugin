/*
 * The MIT License
 * 
 * Copyright (c) 2011-2012, Jesse Farinacci
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package hudson.views.tabbar;

import hudson.Extension;
import hudson.views.ViewsTabBarDescriptor;
import hudson.views.ViewsTabBar;
import net.sf.json.JSONObject;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

/**
 * This plugin provides an alternate rendering of the Views bar which runs along
 * the top of all views. This plugin is useful for instances which have a very
 * large number of views and want a compact rendering.
 * 
 * @author <a href="mailto:jieryn@gmail.com">Jesse Farinacci</a>
 * @since 1.0
 */
public final class DropDownViewsTabBar extends ViewsTabBar {
    @Extension
    public static class DescriptorImpl extends ViewsTabBarDescriptor {
        /**
         * Whether to show the job count, e.g. the <code>(42)</code> part of
         * <code>All (42)</code>, in the drop down label name.
         * 
         * @since 1.3
         */
        private boolean showJobCount;

        public DescriptorImpl() {
            super();
            load();
        }

        @Override
        public boolean configure(final StaplerRequest request,
                final JSONObject jsonObject) {
            showJobCount = jsonObject.getBoolean("showJobCount");
            save();
            return true;
        }

        @Override
        public String getDisplayName() {
            return Messages.DisplayName();
        }

        public boolean isShowJobCount() {
            return showJobCount;
        }

        public void setShowJobCount(final boolean showJobCount) {
            this.showJobCount = showJobCount;
            save();
        }
    }

    @DataBoundConstructor
    public DropDownViewsTabBar() {
        super();
    }
}
