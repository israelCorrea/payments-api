package br.com.bank.payments.service;

import br.com.bank.payments.entity.SystemsNotification;
import br.com.bank.payments.repository.SystemsNotificationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SystemNotificationServiceTest {

    @Mock
    private SystemsNotificationRepository systemsNotificationRepository;

    @InjectMocks
    private SystemNotificationService systemNotificationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCheckNotification() {

        List<SystemsNotification> systemsNotificationList = new ArrayList<>();
        SystemsNotification notification1 = new SystemsNotification();
        SystemsNotification notification2 = new SystemsNotification();
        systemsNotificationList.add(notification1);
        systemsNotificationList.add(notification2);

        List<SystemsNotification> result = systemNotificationService.checkNotification(systemsNotificationList);

        assertNotNull(result);
        assertEquals(systemsNotificationList.size(), result.size());
        assertTrue(notification1.isNotified());
        assertTrue(notification2.isNotified());
        verify(systemsNotificationRepository, times(2)).save(any(SystemsNotification.class));
    }

    @Test
    void testCheckNotification_NotificationListEmpty() {

        List<SystemsNotification> systemsNotificationList = new ArrayList<>();

        List<SystemsNotification> result = systemNotificationService.checkNotification(systemsNotificationList);

        assertNotNull(result);
        assertEquals(0, result.size());
        verify(systemsNotificationRepository, never()).save(any());
    }

    @Test
    void testCheckNotification_SingleNotification() {
        SystemsNotification notification = new SystemsNotification();
        List<SystemsNotification> systemsNotificationList = List.of(notification);

        List<SystemsNotification> result = systemNotificationService.checkNotification(systemsNotificationList);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(notification.isNotified());
        verify(systemsNotificationRepository, times(1)).save(notification);
    }

    @Test
    void testCheckNotification_MultipleNotifications() {

        SystemsNotification notification1 = new SystemsNotification();
        SystemsNotification notification2 = new SystemsNotification();
        List<SystemsNotification> systemsNotificationList = List.of(notification1, notification2);

        List<SystemsNotification> result = systemNotificationService.checkNotification(systemsNotificationList);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(notification1.isNotified());
        assertTrue(notification2.isNotified());
        verify(systemsNotificationRepository, times(2)).save(any(SystemsNotification.class));
    }
}
