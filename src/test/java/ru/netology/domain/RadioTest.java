package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(7);
        radio.increaseVolume();
        assertEquals(8, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(7);
        radio.decreaseVolume();
        assertEquals(6, radio.getCurrentVolume());
    }

    @Test
    void shouldSetNextChannel() {
        Radio radio = new Radio(6,9);
        radio.increaseChannel();
        assertEquals(7, radio.getCurrentChannel());
    }

    @Test
    void shouldSetPreviousChannel() {
        Radio radio = new Radio(6,9);
        radio.decreaseChannel();
        assertEquals(5, radio.getCurrentChannel());
    }

    @Test
    public void shouldIncreaseVolumeFromMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolumeFromMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetDesiredChannel() {
        Radio radio = new Radio();
        radio.setCurrentChannel(5);
        assertEquals(5, radio.getCurrentChannel());
    }

    @Test
    public void shouldSetPreviousChannelFromMin() {
        int expectedMaxChannel = 10;
        Radio radio = new Radio(0 , expectedMaxChannel);
        radio.decreaseChannel();
        assertEquals(expectedMaxChannel, radio.getCurrentChannel());
    }

    @Test
    public void shouldSetNextChannelFromMax() {
        Radio radio = new Radio(10, 10);
        radio.increaseChannel();
        assertEquals(0, radio.getCurrentChannel());
    }

    @Test
    public void shouldNotSetVolumeGreaterThanMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(250);
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetNextChannelFromAnyValue() {
        Radio radio = new Radio();
        radio.setCurrentChannel(320);
        assertEquals(9, radio.getCurrentChannel());
    }

    @Test
    public void shouldSetDesiredChannelAny() {
        Radio radio = new Radio();
        radio.setCurrentChannel(35);
        assertEquals(9, radio.getCurrentChannel());
    }

    @Test
    public void shouldSetDesiredChannelAnyMinus() {
        Radio radio = new Radio();
        radio.setCurrentChannel(-35);
        assertEquals(0, radio.getCurrentChannel());
    }

    @Test
    public void shouldSetNextChannelFromAnyMinus() {
        Radio radio = new Radio();
        radio.setCurrentChannel(-320);
        radio.increaseChannel();
        assertEquals(1, radio.getCurrentChannel());
    }

    @Test
    public void shouldSetPreviousChannelFromAnyMinus() {
        Radio radio = new Radio();
        radio.setCurrentChannel(-320);
        radio.decreaseChannel();
        assertEquals(9, radio.getCurrentChannel());
    }

    @Test
    public void shouldDecreaseVolumeFromAnyMinus() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-100);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolumeFromAnyMinus() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-100);
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }
}



