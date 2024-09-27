package org.example.carstarttdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
 *   目的：測試鑰匙是否插入車輛，並驗證鑰匙是否正確
 *   --------------------------------
 *   流程：
 *       (1) 創建一把鑰匙（Key）。
 *       (2) 檢查 isInserted() 方法應該返回 true。
 *       (3) 檢查 isValidKey() 方法驗證鑰匙的 ID 是否正確。
 *   --------------------------------
 *   例外處理：
 *       (1) 如果鑰匙未插入，車輛應該無法啟動。
 *       (2) 如果鑰匙的 ID 不匹配，車輛無法啟動。
 * */
public class KeyTest {

    @Test
    void test_key_execute_successful() {

        Key key = new Key(true, "1234");

        boolean valid = key.isValid(key);
        boolean inserted = key.isInserted(key);

        assertThat(valid).isEqualTo(true);
        assertThat(inserted).isEqualTo(true);
    }

    @Test
    void test_key_did_not_valid() {

        Key key = new Key(true, "4321");

        boolean valid = key.isValid(key);
        boolean inserted = key.isInserted(key);

        assertThat(valid).isEqualTo(false);
        assertThat(inserted).isEqualTo(true);
    }

    @Test
    void test_key_did_not_inserted() {

        Key key = new Key(false, "1234");

        boolean valid = key.isValid(key);
        boolean inserted = key.isInserted(key);

        assertThat(valid).isEqualTo(true);
        assertThat(inserted).isEqualTo(false);
    }
}
