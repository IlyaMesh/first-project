/*
 * Copyright
 */

package com.firstproject.frontend.gwt.startpage.client.table;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * Simple table.
 *
 * @since 0.0.1
 */
public class TableView extends Composite {

    /**
     * Some name.
     */
    private final String name;

    /**
     * UI binder.
     */
    private final TableViewUiBinder binder;

    /**
     * Constructor which create a view according to markup from MainView.ui.xml.
     * @param binder Ui binder for this view.
     */
    @Inject
    public TableView(final TableViewUiBinder binder) {
        this.binder = binder;
        this.name = "It's simple table";
    }

    /**
     * Init our view.
     * @return This object.
     */
    public final TableView init() {
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
    interface TableViewUiBinder extends UiBinder<Widget, TableView> {
    }
}
