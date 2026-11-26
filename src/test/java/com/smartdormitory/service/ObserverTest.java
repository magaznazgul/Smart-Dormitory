package com.smartdormitory.service;

import com.smartdormitory.domain.Request;
import com.smartdormitory.domain.RequestStatus;
import com.smartdormitory.infra.InMemoryRequestRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {

    @Test
    void observerShouldBeNotifiedWhenRequestStatusChanges() {
        InMemoryRequestRepository repository = new InMemoryRequestRepository();

        Request request = new Request(
                1, "Айдана", "205",
                "Кран сломан", "Жалпы өтінім"
        );

        repository.save(request);

        RequestService service = new RequestService(repository);

        boolean[] notified = {false};

        service.addObserver(changedRequest -> {
            notified[0] = true;
            assertEquals(RequestStatus.ACCEPTED, changedRequest.getStatus());
        });

        service.updateStatus(1, RequestStatus.ACCEPTED);

        assertTrue(notified[0]);
    }
}