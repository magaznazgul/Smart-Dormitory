package com.smartdormitory.ui;

import com.smartdormitory.domain.*;
import com.smartdormitory.service.*;
import com.smartdormitory.infra.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private final Scanner scanner = new Scanner(System.in);

    private final RequestService requestService;
    private final VisitorCollection visitorCollection;
    private final NotificationService notificationService;

    private final List<Announcement> announcements = new ArrayList<>();

    public ConsoleUI() {
        InMemoryRequestRepository repository = new InMemoryRequestRepository();

        requestService = new RequestService(repository);
        requestService.addObserver(new ResidentNotificationObserver());

        visitorCollection = new VisitorCollection();

        notificationService = new SmsNotificationAdapter(
                new LegacySmsService()
        );
    }

    public void start() {
        while (true) {
            System.out.println("\n================================");
            System.out.println("       SMART DORMITORY");
            System.out.println("================================");
            System.out.println("1. Өтінім қосу");
            System.out.println("2. Барлық өтінімдерді көру");
            System.out.println("3. Өтінім күйін өзгерту");
            System.out.println("4. Келушіні тіркеу");
            System.out.println("5. Келушілер журналын көру");
            System.out.println("6. Хабарландыру жариялау");
            System.out.println("7. Хабарландыруларды көру");
            System.out.println("0. Шығу");
            System.out.print("Таңдаңыз: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> createRequest();
                case 2 -> showRequests();
                case 3 -> updateRequestStatus();
                case 4 -> addVisitor();
                case 5 -> showVisitors();
                case 6 -> addAnnouncement();
                case 7 -> showAnnouncements();
                case 0 -> {
                    System.out.println("Бағдарлама аяқталды!");
                    return;
                }
                default -> System.out.println("Қате таңдау!");
            }
        }
    }

    private void createRequest() {
        System.out.print("Тұрғынның аты-жөні: ");
        String name = scanner.nextLine();

        System.out.print("Бөлме нөмірі: ");
        String room = scanner.nextLine();

        System.out.print("Өтінім сипаттамасы: ");
        String description = scanner.nextLine();

        System.out.print("Санаты (repair немесе other): ");
        String category = scanner.nextLine();

        int id = requestService.getAllRequests().size() + 1;

        requestService.createRequest(
                id, name, room, description, category
        );

        System.out.println("Өтінім сәтті қосылды!");

        System.out.print("Телефон нөмірі: ");
        String phone = scanner.nextLine();

        notificationService.sendNotification(
                phone,
                "Сіздің өтініміңіз қабылданды. Нөмірі: " + id
        );
    }

    private void showRequests() {
        List<Request> requests = requestService.getAllRequests();

        if (requests.isEmpty()) {
            System.out.println("Өтінімдер жоқ.");
            return;
        }

        for (Request request : requests) {
            System.out.println(request);
        }
    }

    private void updateRequestStatus() {
        System.out.print("Өтінім нөмірі: ");
        int id = readInt();

        System.out.println("1 - ACCEPTED");
        System.out.println("2 - IN_PROGRESS");
        System.out.println("3 - COMPLETED");
        System.out.println("4 - REJECTED");
        System.out.print("Жаңа күйді таңдаңыз: ");

        int choice = readInt();

        RequestStatus status;

        switch (choice) {
            case 1 -> status = RequestStatus.ACCEPTED;
            case 2 -> status = RequestStatus.IN_PROGRESS;
            case 3 -> status = RequestStatus.COMPLETED;
            case 4 -> status = RequestStatus.REJECTED;
            default -> {
                System.out.println("Қате таңдау!");
                return;
            }
        }

        try {
            requestService.updateStatus(id, status);
            System.out.println("Өтінім күйі өзгертілді!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addVisitor() {
        System.out.print("Келушінің аты-жөні: ");
        String visitorName = scanner.nextLine();

        System.out.print("Тұрғынның аты-жөні: ");
        String residentName = scanner.nextLine();

        System.out.print("Бөлме нөмірі: ");
        String room = scanner.nextLine();

        Visitor visitor = new Visitor(
                visitorName, residentName, room
        );

        visitorCollection.addVisitor(visitor);

        System.out.println("Келуші тіркелді!");
    }

    private void showVisitors() {
        if (visitorCollection.getSize() == 0) {
            System.out.println("Келушілер жоқ.");
            return;
        }

        System.out.println("\nКЕЛУШІЛЕР ЖУРНАЛЫ:");

        for (Visitor visitor : visitorCollection) {
            System.out.println(visitor);
        }
    }

    private void addAnnouncement() {
        System.out.print("Хабарландыру тақырыбы: ");
        String title = scanner.nextLine();

        System.out.print("Хабарландыру мәтіні: ");
        String message = scanner.nextLine();

        announcements.add(new Announcement(title, message));

        System.out.println("Хабарландыру жарияланды!");
    }

    private void showAnnouncements() {
        if (announcements.isEmpty()) {
            System.out.println("Хабарландырулар жоқ.");
            return;
        }

        for (Announcement announcement : announcements) {
            System.out.println("\n" + announcement);
        }
    }

    private int readInt() {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Сан енгізіңіз: ");
            }
        }
    }
}