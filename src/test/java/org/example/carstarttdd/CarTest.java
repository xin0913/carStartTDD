package org.example.carstarttdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/*
 *   目的：測試車子是否啟動
 *   --------------------------------
 *   流程：
 *       (1) 有一台"車子"，這台車需要有一個"鑰匙"和"引擎"。
 *       (2) 檢查 key.isInserted() 方法應該返回 true。
 *       (3) 檢查 key.isValidKey() 方法驗證鑰匙的 ID 是否正確。
 *       (4) 檢查 engine.isStart() 方法應該返回 true。
 *   --------------------------------
 *   例外處理：
 *       (1) 如果沒有插入鑰匙，車子不能啟動。
 *       (2) 如果引擎無法啟動，車子也無法啟動。
 * */
@ExtendWith(MockitoExtension.class)
public class CarTest {

    @InjectMocks
    private Car car;

    @Mock
    private Key key;

    @Mock
    private Engine engine;

    @Test
    void test_car_execute_successful() {

        Key successfulKey = new Key(true, "1234");

        given(key.isValid(successfulKey)).willReturn(true);
        given(key.isInserted(successfulKey)).willReturn(true);
        given(engine.isStart(successfulKey)).willReturn(true);

        boolean carStatus = car.start(successfulKey);

        assertThat(carStatus).isEqualTo(true);
    }

    @Test
    void test_car_did_not_valid_and_inserted() {

        Key failedKey = new Key(false, "4321");

        given(key.isValid(failedKey)).willReturn(false);
        given(key.isInserted(failedKey)).willReturn(false);
        given(engine.isStart(failedKey)).willReturn(false);

        boolean carStatus = car.start(failedKey);

        assertThat(carStatus).isEqualTo(false);
    }

    @Test
    void test_car_did_not_valid() {

        Key failedKey = new Key(true, "1234");

        given(key.isValid(failedKey)).willReturn(false);
        given(key.isInserted(failedKey)).willReturn(true);
        given(engine.isStart(failedKey)).willReturn(false);

        boolean carStatus = car.start(failedKey);

        assertThat(carStatus).isEqualTo(false);
    }

    @Test
    void test_car_did_not_inserted() {

        Key failedKey = new Key(false, "1234");

        given(key.isValid(failedKey)).willReturn(true);
        given(key.isInserted(failedKey)).willReturn(false);
        given(engine.isStart(failedKey)).willReturn(false);

        boolean carStatus = car.start(failedKey);

        assertThat(carStatus).isEqualTo(false);
    }
}
