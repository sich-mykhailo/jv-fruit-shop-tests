package core.basesyntax.service;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.Operation;
import core.basesyntax.service.operation.BalanceHandlerImpl;
import core.basesyntax.service.operation.Handler;
import core.basesyntax.service.operation.PurchaseHandlerImpl;
import core.basesyntax.service.operation.ReturnHandlerImpl;
import core.basesyntax.service.operation.SupplyHandlerImpl;
import java.util.HashMap;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class OperationStrategyImplTest {
    private static OperationStrategy operationStrategy;
    private static Map<Operation, Handler> handlerMap;
    private static Handler expected;
    private static Handler actual;

    @BeforeClass
    public static void beforeClass() {
        handlerMap = new HashMap<>();
        handlerMap.put(Operation.BALANCE, new BalanceHandlerImpl());
        handlerMap.put(Operation.SUPPLY, new SupplyHandlerImpl());
        handlerMap.put(Operation.PURCHASE, new PurchaseHandlerImpl());
        handlerMap.put(Operation.RETURN, new ReturnHandlerImpl());
        operationStrategy = new OperationStrategyImpl(handlerMap);
    }

    @Test
    public void getHandler_BalanceHandler_Ok() {
        expected = handlerMap.get(Operation.BALANCE);
        actual = operationStrategy.getHandler(Operation.BALANCE);
        assertEquals(expected, actual);
    }

    @Test
    public void getHandler_SupplyHandler_Ok() {
        expected = handlerMap.get(Operation.SUPPLY);
        actual = operationStrategy.getHandler(Operation.SUPPLY);
        assertEquals(expected, actual);
    }

    @Test
    public void getHandler_ReturnHandler_Ok() {
        expected = handlerMap.get(Operation.RETURN);
        actual = operationStrategy.getHandler(Operation.RETURN);
        assertEquals(expected, actual);
    }

    @Test
    public void getHandler_PurchaseHandler_Ok() {
        expected = handlerMap.get(Operation.PURCHASE);
        actual = operationStrategy.getHandler(Operation.PURCHASE);
        assertEquals(expected, actual);
    }

    @Test (expected = RuntimeException.class)
    public void getHandler_HandlerNull_NotOk() {
        actual = operationStrategy.getHandler(null);
    }
}