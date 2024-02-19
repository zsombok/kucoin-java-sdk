/**
 * Copyright 2019 Mek Global Limited.
 */
package com.kucoin.sdk.rest.interfaces;

import com.kucoin.sdk.rest.request.MarginOrderCreateRequest;
import com.kucoin.sdk.rest.response.*;
import retrofit2.http.Query;

import java.io.IOException;
import java.util.List;

/**
 * Created by ezreal on 2020/12/08.
 */
public interface MarginAPI {

    /**
     * Get Mark Price
     * <p>
     * Request via this endpoint to get the index price of the specified symbol.
     * </p>
     * @param symbol
     * @return
     */
    MarkPriceResponse getMarkPrice(String symbol) throws IOException;

    /**
     * Get Margin Configuration Info
     * <p>
     * Request via this endpoint to get the configure info of the margin.
     * </p>
     * @return
     */
    MarginConfigResponse getMarginConfig() throws IOException;

    /**
     * Get Margin Account
     * <p>
     * Request via this endpoint to get the info of the margin account.
     * </p>
     * @return
     */
    MarginAccountResponse getMarginAccount() throws IOException;

    /**
     * You can place two types of orders: limit and market. Orders can only be placed if your account has sufficient funds.
     * Once an order is placed, your account funds will be put on hold for the duration of the order.
     * How much and which funds are put on hold depends on the order type and parameters specified. See the Holds details below.
     * @param request
     * @return
     */
    MarginOrderCreateResponse createMarginOrder(MarginOrderCreateRequest request) throws IOException;

    /**
     *  Get Margin Price Strategy
     *  <p>
     *  Request via this endpoint to get the cross/isolated margin risk limit.
     *  </p>
     * @param marginModel
     * @return
     */
    List<MarginPriceStrategyResponse> getMarginPriceStrategy(String marginModel) throws IOException;

    /**
     * Get Leveraged Token Info
     * @param currency
     * @return EtfInfoResponse
     * @throws IOException
     */
    List<EtfInfoResponse> getEtfInfo(String currency) throws IOException;

    /**
     * This interface can obtain the risk limit and currency configuration of cross margin.
     *
     * @param symbol
     * @param currency
     * @return
     */
    List<CrossMarginCurrencyResponse> getMarginCurrencies(String symbol, String currency) throws IOException;

    /**
     * Get Account Detail - Cross Margin
     * @param quoteCurrency currently only supports USDT, KCS, BTC, USDT as default
     * @param queryType Query account type (default MARGIN), MARGIN - only query low frequency cross margin account, MARGIN_V2-only query high frequency cross margin account, ALL - consistent aggregate query with the web side
     * @return
     */
    MarginAccountResponse getMarginAccounts(String quoteCurrency, String queryType) throws IOException;

}
