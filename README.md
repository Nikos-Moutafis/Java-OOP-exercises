## Java_OOP_exercises



- [Bank App](/bank_app/): This app demonstrates a simple  Service Oriented Architecture with clear separation of concerns between DAO, DTO and Service layer.It uses a     List as a datasource to store users credentials and account's amount. 

- [Mobile contacts App](/mobilecontacts_app/):  [The MobileContactDAOImpl](/mobilecontacts_app/dao/MobileContactDAOImpl.java) class provides methods for inserting,       updating, deleting, and retrieving MobileContact objects from an in-memory data source.The Proxy  Pattern is implemented by this class in that it acts as a               surrogate for the actual data source.The [The MobileContactDAOImpl](/mobilecontacts_app/service/MobileContactServiceImpl) class uses the Decorator pattern, Delegation    pattern,   and Proxy pattern (Wrapper class of DAO). It also uses Dependency  Injection in the constructor to inject the DAO object.In addition to that [model](/mobilecontacts_app/model/) classes are using [interface](mobilecontacts_app/model/IdentifiableEntity.java) and [abstract class](mobilecontacts_app/model/AbstractEntity.java) to take advantage of inheritance(feature of object-oriented programming).


- [Shapes App ](/shapes_app/): 




