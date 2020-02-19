/*
 * Copyright
 */

package com.firstproject.frontend.gwt.startpage.client.span;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * Span span span!
 *
 * @since 0.0.1
 */
public class SpanView extends Composite {

    /**
     * Some name.
     */
    private final String name;

    /**
     * UI binder.
     */
    private final SpanViewUiBinder binder;

    /**
     * Constructor which create a view according to markup from MainView.ui.xml.
     * @param binder Ui binder for this view.
     */
    @Inject
    public SpanView(final SpanViewUiBinder binder) {
        this.binder = binder;
        this.name = "Span span span";
    }

    /**
     * Init our view.
     * @return This object.
     */
    public final SpanView init() {
        super.initWidget(this.binder.createAndBindUi(this));
        return this;
    }

    /**
     * Get name of view.
     * @return Name of view.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Interface for autoimplementation of our view.
     * @since 0.0.1
     */
    interface SpanViewUiBinder extends UiBinder<Widget, SpanView> {
    }
}
