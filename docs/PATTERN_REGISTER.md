# Design Pattern Register — Smart Dormitory

## 1. Factory Method

- **Pattern:** Factory Method
- **Lecture:** Creational Design Patterns
- **Problem:** Өтінімдердің әртүрлі түрлерін құру логикасын бір-бірінен бөлу қажет.
- **Classes:** `RequestFactory`, `RepairRequestFactory`, `GeneralRequestFactory`
- **Test:** `RequestFactoryTest`
- **Alternative:** Abstract Factory

## 2. Adapter

- **Pattern:** Adapter
- **Lecture:** Structural Design Patterns
- **Problem:** Ескі SMS қызметінің интерфейсі жаңа хабарлама жіберу интерфейсіне сәйкес келмейді.
- **Classes:** `NotificationService`, `LegacySmsService`, `SmsNotificationAdapter`
- **Test:** `AdapterTest`
- **Alternative:** Facade

## 3. Observer

- **Pattern:** Observer
- **Lecture:** Behavioral Design Patterns
- **Problem:** Өтінімнің күйі өзгерген кезде тұрғынға автоматты түрде хабарлау қажет.
- **Classes:** `RequestObserver`, `ResidentNotificationObserver`, `RequestService`
- **Test:** `ObserverTest`
- **Alternative:** Mediator

## 4. Iterator

- **Pattern:** Iterator
- **Lecture:** Behavioral Design Patterns
- **Problem:** Келушілер тізімін ішкі құрылымын көрсетпей біртіндеп қарау қажет.
- **Classes:** `VisitorIterator`, `VisitorCollection`, `Visitor`
- **Test:** `IteratorTest`
- **Alternative:** Stream API