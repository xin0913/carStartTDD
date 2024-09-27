package org.example.carstarttdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

/*
 *   目的：測試引擎是否可以成功啟動
 *   --------------------------------
 *   流程：
 *       (1) 創建一把鑰匙（Key），設置為已插入且為有效鑰匙。
 *       (2) 創建引擎（Engine）。
 *       (3) 調用引擎的 isStart(Key) 方法，並確認引擎成功啟動。
 *   --------------------------------
 *   例外處理：
 *       (1) 如果鑰匙未插入，引擎無法啟動。
 *       (2) 如果鑰匙無效（ID 不匹配），引擎無法啟動。
 * */
@ExtendWith(MockitoExtension.class)
public class EngineTest {

    @InjectMocks
    private Engine engine;

    @Test
    void test_engine_execute_successful() {

        Key key = new Key(true, "1234");

        boolean engineStatus = engine.isStart(key);

        assertThat(engineStatus).isEqualTo(true);
    }

    @Test
    void test_key_did_not_valid() {

        Key key = new Key(true, "4321");

        boolean engineStatus = engine.isStart(key);

        assertThat(engineStatus).isEqualTo(false);
    }

    @Test
    void test_key_did_not_inserted() {

        Key key = new Key(false, "1234");

        boolean engineStatus = engine.isStart(key);

        assertThat(engineStatus).isEqualTo(false);
    }
}
