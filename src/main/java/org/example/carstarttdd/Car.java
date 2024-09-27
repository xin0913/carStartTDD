package org.example.carstarttdd;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Car {

    private final Key key;
    private final Engine engine;

    // 直接檢查傳入的鑰匙對象是否有效和插入
    public boolean start(Key carKey) {
        boolean isValid = key.isValid(carKey);
        boolean isInserted = key.isInserted(carKey);
        boolean isStart = engine.isStart(carKey);

        return isValid && isInserted && isStart;
    }
}
