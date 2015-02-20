/*
 * The MIT License
 * 
 * Copyright (c) 2011-2012, Jesse Farinacci, Frederic Gurr
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
import jenkins.model.GlobalConfiguration;
import net.sf.json.JSONObject;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

/**
 * The {@link jenkins.model.GlobalConfiguration} configuration data for this
 * plugin, {@link javax.inject.Inject}ed into other {@link hudson.Extension}s.
 * 
 * @author <a href="mailto:jieryn@gmail.com">Jesse Farinacci</a>
 * @since 1.6
 */
@Extension
public final class DropDownGlobalConfiguration extends GlobalConfiguration {
    /**
     * Whether to show the job count, e.g. the <code>(42)</code> part of
     * <code>All (42)</code>, in the drop down label name.
     */
    public static final boolean DEFAULT_SHOW_JOB_COUNT = true;
    public static final boolean DEFAULT_FILTER_VIEWS = false;

    /**
     * Whether to show the job count, e.g. the <code>(42)</code> part of
     * <code>All (42)</code>, in the drop down label name.
     */
    private boolean             showJobCount;
    private boolean				filterViews;

    public DropDownGlobalConfiguration() {
        this(DEFAULT_SHOW_JOB_COUNT, DEFAULT_FILTER_VIEWS);
    }

    @DataBoundConstructor
    public DropDownGlobalConfiguration(final boolean showJobCount, final boolean filterViews) {
        super();
        this.showJobCount = showJobCount;
        this.filterViews = filterViews;
        load();
    }

    @Override
    public boolean configure(final StaplerRequest request, final JSONObject json)
            throws FormException {
//        request.bindJSON(this, json);
        this.showJobCount = json.getBoolean("showJobCount");
        this.filterViews = json.getBoolean("filterViews");
        save();
        return true;
    }

    @Override
    public String getDisplayName() {
        return Messages.DisplayName();
    }

    public boolean isShowJobCount() {
        return this.showJobCount;
    }
    
    public boolean isFilterViews() {
        return this.filterViews;
    }
}
