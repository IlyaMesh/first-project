/*
 * Copyright
 */

package com.firstproject.frontend.gwt.startpage.client.factorial;

import com.firstproject.backend.model.FactorialRequest;
import com.firstproject.backend.model.FactorialResults;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

/**
 * Using restyGWT for call back end code.
 *
 * @since 0.0.1
 */
public interface FactorialRest extends RestService {

    /**
     * Calculate flat factorial.
     *
     * @param value Value for calculation.
     * @param callback Callback predicate.
     */
    @GET
    @Path("/factorial/flat/{value}")
    void flat(@PathParam("value") Integer value, MethodCallback<FactorialResults> callback);

    /**
     * Calculate recursive factorial.
     * @param value Value for calculation.
     * @param callback Callback predicate.
     */
    @GET
    @Path("/factorial/recursive")
    void recursive(@QueryParam("value") Integer value, MethodCallback<FactorialResults> callback);

    /**
     * Calculate factoiral with automatic define.
     *
     * @param request Request for calculation.
     * @param callback Callback predicate.
     */
    @POST
    @Path("/factorial/auto")
    void auto(FactorialRequest request, MethodCallback<FactorialResults> callback);

}
