package com.accio.mongodb.utilities.uuid_gen;
/**
 * @author Esh
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestListener implements ServletRequestListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestListener.class);
    private static final String REQUEST_ID = "RequestId";

    @Override
    public void requestInitialized(ServletRequestEvent arg0) {
        String uniqueId = CommonUtils.getUniqueId();
        HttpServletRequest request = ((HttpServletRequest) arg0.getServletRequest());
        LOGGER.info("HttpReq[init]:RequestId:{}, Path:{}", uniqueId, request.getRequestURL().toString());
        MDC.put(REQUEST_ID, uniqueId);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent arg0) {
        LOGGER.info("HttpReq[destroyed]:RequestId:{}", MDC.get(REQUEST_ID));
        MDC.clear();
    }
}
