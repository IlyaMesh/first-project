/*
 * Copyright
 */

package com.firstproject.frontend.gwt.startpage.client.main;

import com.firstproject.frontend.gwt.startpage.client.span.SpanView;
import com.firstproject.frontend.gwt.startpage.client.table.TableView;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * Main view for our widget.
 *
 * @since 0.0.1
 */
public class MainView extends Composite {

    /**
     * Title of this page.
     */
    @UiField
    //@checkstyle VisibilityModifierCheck (2 lines)
    protected SpanElement title;

    /**
     * Workspace.
     */
    @UiField
    //@checkstyle VisibilityModifierCheck (2 lines)
    protected HTMLPanel workspace;

    /**
     * UI binder.
     */
    private final MainViewUiBinder binder;

    /**
     * Table view.
     */
    private final TableView tableview;

    /**
     * Beutifull span.
     */
    private final SpanView spanview;

    /**
     * Constructor which create a view according to markup from MainView.ui.xml.
     * @param binder Ui binder for this view.
     * @param tableview Table view inject.
     * @param spanview Span view inject.
     */
    @Inject
    public MainView(
        final MainViewUiBinder binder,
        final TableView tableview,
        final SpanView spanview
    ) {
        this.binder = binder;
        this.tableview = tableview;
        this.spanview = spanview;
    }

    /**
     * Init our view.
     * @return This object.
     */
    public final MainView init() {
        super.initWidget(this.binder.createAndBindUi(this));
        this.tableview.init();
        this.spanview.init();
        return this;
    }

    /**
     * Display table.
     * @param event Event.
     */
    @UiHandler("buttonTable")
    public void onTableButton(final ClickEvent event) {
        this.workspace.clear();
        this.workspace.add(this.tableview);
        this.title.setInnerText(this.tableview.getName());
    }

    /**
     * Display span span span.
     * @param event Event
     */
    @UiHandler("buttonSpan")
    public void onSpanButton(final ClickEvent event) {
        this.workspace.clear();
        this.workspace.add(this.spanview);
        this.title.setInnerText(this.spanview.getName());
    }

    /**
     * Interface for autoimplementation of our view.
     * @since 0.0.1
     */
    interface MainViewUiBinder extends UiBinder<Widget, MainView> {
    }
}
