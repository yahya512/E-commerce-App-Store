# E-Commerce App

An Android **E-Commerce application** built with **Kotlin**, following **Clean Architecture** and **MVVM** principles.

The application allows users to browse a list of products and view detailed information about each selected product.

## Features

* Browse available products
* Display products using `RecyclerView`
* View detailed product information
* Navigate from the product list to product details
* Display product name, price, category, description, and image

## Screens

### 1. Product List

The main screen displays a list of available products using **RecyclerView**.

Each product is presented in a simple and organized item layout, allowing the user to browse through the available products and select any product to view more information.

![Product List](https://github.com/yahya512/E-commerce-App-Store/blob/57fef7ad150a41867c8b37132bf2f2e15bb8d2ec/app/src/main/java/com/example/e_commerceapp/screenshots/Screenshot_20260901_210033.png)

---

### 2. Product Details

After selecting a product, the application navigates to the **Product Details** screen.

The screen displays the selected product's main information, including:

* Product name
* Price
* Category
* Description
* Product image

This provides the user with a complete overview of the selected product.

![Product Details](https://github.com/yahya512/E-commerce-App-Store/blob/57fef7ad150a41867c8b37132bf2f2e15bb8d2ec/app/src/main/java/com/example/e_commerceapp/screenshots/Screenshot_20260901_210049.png)


## 🏗️ Architecture

- Clean Architecture
- MVVM Pattern
- Repository Pattern
- Use Cases
- StateFlow for Reactive UI
- Hilt for Dependency Injection

## 📱 Android Components

- Activity & Activity Lifecycle
- Fragment & Fragment Lifecycle
- ViewModel
- Navigation Component
- RecyclerView with ListAdapter

## 📦 Networking

- Retrofit
- OkHttp
- Kotlin Coroutines

## 🖼️ Image Loading

- Glide

## Project Structure

```text
E-Commerce App
│
├── products
│   ├── data
│   ├── domain
│   └── presentation
│
└── core
    └── shared components
```

The structure keeps the product feature organized while maintaining a clear separation between the different application layers.

## Purpose

This project was built to practice developing an Android E-Commerce application using modern Android development practices, including Clean Architecture, MVVM, dependency injection, networking, and RecyclerView-based UI.
