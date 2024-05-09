# Paycard4j
`Paycard4j` est une bibliothèque Java conçue pour faciliter l'intégration de l'API de paiement Paycard dans des applications. Elle agit comme une couche d'abstraction, simplifiant les interactions avec l'API de Paycard et permettant ainsi aux développeurs de se concentrer sur la logique de leur application sans se préoccuper des détails de l'API.

En utilisant `Paycard4j`, vous pourrez effectuer des paiements via Orange Money Guinée, MTN MoMo, VISA, et Paycard.

## Prérequis
* JDK 11 ou supérieur
* Apache Maven 3.3.9 ou supérieur
* Un compte sur [Paycard](https://paycard.co/)

## Installation
Pour Maven, ajoutez cette dépendance dans votre fichier `pom.xml` :

```xml
<dependency>
  <groupId>io.github.moudjames23</groupId>
  <artifactId>paycard4j</artifactId>
  <version>1.0.0</version>
</dependency>
```

Pour Gradle :

```gradle
implementation 'io.github.moudjames23:paycard4j:1.0.0'
```

## Documentation

### Initialisation
Initialisez l'instance de paiement avec votre code marchand :

```java
Paycard paycard = new Paycard("xxxxxx");
```

### Configuration des informations de paiement

```java
CreatePaymentRequest paymentRequest = CreatePaymentRequest.builder()
                .amount(50000) // Montant du paiement
                .description("Commande 23") // Description du paiement
                .build();
```

### Exécution du paiement

```java
CreatePaymentResponse response = paycard.createPayment(paymentRequest);
```

### Redirection
Redirigez l'utilisateur vers la page de paiement si l'opération est réussie :

```java
response.getPaymentUrl();
```
### Référence unique
Obtenez la référence unique du paiement :

```java
response.getOperationReference();
```

Cette référence est générée par Paycard, mais vous pouvez également la personnaliser :

```java
CreatePaymentRequest paymentRequest = CreatePaymentRequest.builder()
                .amount(50000) 
                .reference("MA_REF_UNIQUE")
                .description("Commande 23")
                .build();
```

### Statut du paiement
Pour vérifier le statut d'un paiement, utilisez :

```java
Paycard paycard = new Paycard("xxxxxx");
PaymentStatusResponse paymentStatus = paycard.getPaymentStatus("REF");
paymentStatus.getStatus();
```

Les statuts possibles sont : `new`, `pending`, `success`, `failed`, `canceled`, et `error`.

### Méthodes de paiement
Sélectionnez la méthode de paiement désirée :

```java
CreatePaymentRequest paymentRequest = CreatePaymentRequest.builder()
                .amount(50000)
                .paymentMethod(PaymentMethod.ORANGE_MONEY)
                .description("Commande 23")
                .build();
```

Les options disponibles sont :

`PaymentMethod.ORANGE_MONEY` 
`PaymentMethod.MOMO`
`PaymentMethod.CREDIT_CARD`
`PaymentMethod.PAYCARD`

### Gestion du Callback
Définissez une URL de callback lors d'un paiement :

```java
CreatePaymentRequest paymentRequest = CreatePaymentRequest.builder()
                .amount(50000)
                .paymentMethod(PaymentMethod.PAYCARD)
                .callbackUrl("https://monsite.com/api/paiement/status")
                .description("Commande 23")
                .build();
```
**Assurez-vous que l'URL soit sécurisée (https).**

Avec Spring Boot, vous pouvez gérer le callback ainsi :

```java
public void transactionStatus(@RequestBody PaymentStatusResponse paymentStatusResponse)
{
        
}
```
