package org.example.carstarttdd;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Key {

    private final boolean inserted;

    private final String keyId;

    public boolean isValid(Key key) {
        return key.keyId.equals("1234");
    }

    public boolean isInserted(Key key) {
        return key.inserted;
    }
}
