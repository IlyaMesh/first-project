/*
 * Copyright
 */

package com.firstproject.frontend.gwt.startpage.client.factorial;

import com.firstproject.backend.model.FactorialRequest;
import com.firstproject.backend.model.FactorialResults;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

/**
 * Span span span!
 *
 * @since 0.0.1
 */
public class FactorialView extends Composite {

    /**
     * Field for input.
     */
    @UiField
    //@checkstyle VisibilityModifierCheck (2 lines)
    protected TextBox input;

    /**
     * Flat calculation.
     */
    @UiField
    //@checkstyle VisibilityModifierCheck (2 lines)
    protected RadioButton flat;

    /**
     * Recursive calculation.
     */
    @UiField
    //@checkstyle VisibilityModifierCheck (2 lines)
    protected RadioButton recursive;

    /**
     * Auto define calculation.
     */
    @UiField
    //@checkstyle VisibilityModifierCheck (2 lines)
    protected RadioButton auto;

    /**
     * Result of calculation.
     */
    @UiField
    //@checkstyle VisibilityModifierCheck (2 lines)
    protected Label output;

    /**
     * UI binder.
     */
    private final FactorialViewUiBinder binder;

    /**
     * For calling rest services.
     */
    private final FactorialRest rest;

    /**
     * Constructor which create a view according to markup from MainView.ui.xml.
     *
     * @param binder Ui binder for this view.
     * @param rest Rest service for call back end.
     */
    @Inject
    public FactorialView(final FactorialViewUiBinder binder, final FactorialRest rest) {
        this.binder = binder;
        this.rest = rest;
    }

    /**
     * Init our view.
     *
     * @return This object.
     */
    public final FactorialView init() {
        super.initWidget(this.binder.createAndBindUi(this));
        return this;
    }

    /**
     * Send rest query to back end.
     *
     * @param event Using for click event.
     */
    @UiHandler("calculate")
    public void calculateClick(final ClickEvent event) {
        final int value = Integer.parseInt(this.input.getText());
        final FactorialRequest request = new FactorialRequest(value);
        this.rest.auto(
            request,
            new MethodCallback<FactorialResults>() {

                @Override
                public void onFailure(final Method method, final Throwable throwable) {
                    Window.alert(new StringBuilder()
                        .append("Error: ").append(throwable.getMessage()).toString()
                    );
                }

                @Override
                public void onSuccess(final Method method, final FactorialResults results) {
                    FactorialView.this.output.setText(
                        new StringBuilder()
                            .append("Method: ").append(results.getMethod())
                            .append(" Result: ").append(results.getValue()).toString()
                    );
                }
            });
    }

    /**
     * Interface for autoimplementation of our view.
     *
     * @since 0.0.1
     */
    interface FactorialViewUiBinder extends UiBinder<Widget, FactorialView> {
    }
}
