package com.smartdormitory.service;

import com.smartdormitory.infra.LegacySmsService;
import com.smartdormitory.infra.SmsNotificationAdapter;
import org.junit.jupiter.api.Test;
import com.smartdormitory.domain.NotificationService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AdapterTest {

    @Test
    void adapterShouldSendNotificationThroughLegacySmsService() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(output));

            LegacySmsService legacyService = new LegacySmsService();
            NotificationService adapter =
                    new SmsNotificationAdapter(legacyService);

            adapter.sendNotification(
                    "+77001234567",
                    "Өтініміңіз қабылданды"
            );

        } finally {
            System.setOut(originalOut);
        }

        String result = output.toString();

        assertTrue(result.contains("SMS жіберілді!"));
        assertTrue(result.contains("+77001234567"));
        assertTrue(result.contains("Өтініміңіз қабылданды"));
    }
}