package edu.ada.micronaunt.service.Impl;

import edu.ada.micronaunt.service.FinancialService;
import org.slf4j.LoggerFactory;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Logger;

public class YahooFinanceServiceImpl implements FinancialService {
    protected static final Logger logger = (Logger) LoggerFactory.getLogger(YahooFinanceServiceImpl.class);


    @Override
    public Object getFinancialData(String stock_index) {

        Stock stock = null;
        BigDecimal price = BigDecimal.ZERO;
        try {
            stock = YahooFinance.get(stock_index);
            price = stock.getQuote(true).getPrice();
            return price;
        } catch (IOException e) {
            logger.info("This info to the left is red");
        }

        return price;
    }
}
