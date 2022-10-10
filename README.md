# SPSGP-54141-Virtual-Internship---Android-Application-Development-Using-Kotlin
## Build A Grocery Android App - Project 2


https://user-images.githubusercontent.com/66357309/192134033-4770ad4b-7a4c-48bd-ba0a-3bd126ccd88e.mp4


> ### INTRODUCTION
1. ### Overview
- As we can't remember everything, users frequently forget to buy the things they want to buy. Whenever we go to shop for something, one of the things we commonly do is make a  list of items we intend to buy as it is common to forget something if we do not. But an issue with paper lists is that they can be spoiled, torn or lost easily. Also, we need to carry a pen to mark what is bought already. This is both cumbersome and a waste of resources.
2. ### Purpose 
- This is a listing app that tries to resolve this problem. You can enter what you want to buy, in what quantity and its price. It also computes the total price that item will cost. This allows us to reduce clutter as we only need to carry out phone with us to have the list with us.

> ### LITERATURE SURVEY 
1. ### Existing problem 
- The main aim of this project is to list the items so that whenever users go to grocery stores, users will not be able to forget their items and this grocery application helps the users to tackle their day-to-day chaos more effortlessly. It’s not easy for the users to remember every item in this hectic lifestyle, they frequently can’t recall their required necessity so we decided to build an app to store the items in the database for their future use. After buying the items users can delete the added items in the database.
2. ### Proposed solution 
- The goal of this project is to make an app that stores the user items in a cart and can modify and delete the added item in the list. To develop a reliable system, I have some specific goals such as:
  1. Develop a system such that users can add item details like product name, product Quantity, and Product Price.
  2. Develop a database room that is used to store the user data which has already been added by the user in the cart and the user can also remove the previously added item in the cart.
  3. Develop a good UI design that is user friendly to the user.
  4. Develop a good UI that is supported for all android devices.
  
> ### THEORETICAL ANALYSIS 
1. ### Block diagram 
- The grocery cart application project will help the user or admin to store the list of items in proper sequence. User/Admin can add and remove the items in the list according to his/her will. 
    1. UI DESIGN IN THE ANDROID PLATFORM
    2. ANDROID APPLICATION DEVELOPMENT
    3. DATABASE CONNECTION TO STORE USER DATA   
2. Hardware / Software designing 
- The Software Package is developed using Kotlin and Android Studio, basic SQL commands are used to store the data in SQLite database. Development requirement:
    1. Operating System : Windows 10 (64 - bit) or higher
    2. Software : Android Studio
    3. Language :  Kotlin
    4. Emulator : Pixel 5 API 31
    5. RAM : 8 GB (Recommended)
    6. ROM : 20 GB (Minimum)

> ### EXPERIMENTAL INVESTIGATIONS 
In this project, we are using MVVM (Model View ViewModel) for architectural patterns, Room for database, Coroutines and RecyclerView to display the list of items
1. ### MVVM (Model View ViewModel)
- MVVM architecture in android is used to give structure to the project’s code and understand code easily. MVVM is an architectural design pattern in android. MVVM treats Activity classes and XML files as View. This design pattern completely separates the UI from its logic. Here is an image to quickly understand MVVM.
2. ### ROOM Database
- Room persistence library is a database management library and it is used to store the data of apps like grocery item name, grocery item quantity, and grocery item price. Room is a cover layer on SQLite which helps to perform the operation on the database easily.
3. ### RecyclerView
- RecyclerView is a container and it is used to display the collection of data in a large amount of data set that can be scrolled very effectively by maintaining a limited number of views.
4. ### Coroutines
- Coroutines are a lightweight thread, we use coroutines to perform an operation on other threads, by this our main thread doesn’t block and our app doesn’t crash.

> ### RESULT 
We created a basic level solution for the problem. Below are some screenshots of the app.

|<img src="https://user-images.githubusercontent.com/66357309/191430232-53e3adf6-7653-4015-b2fa-d29e1c7f50c7.jpg" width="240">
|<img src="https://user-images.githubusercontent.com/66357309/191430242-24bafc82-85d2-4678-afe7-4036bf7cbacf.jpg" width="240">
|<img src="https://user-images.githubusercontent.com/66357309/191430249-799447ae-5c3c-4b1e-bab3-aa0e254822e0.jpg" width="240">
|<img src="https://user-images.githubusercontent.com/66357309/191430252-afd690a2-a35d-4924-b320-9e83257595eb.jpg" width="240">
|<img src="https://user-images.githubusercontent.com/66357309/191435608-530f5278-8e86-44fe-a30e-7207ca6dfaa2.jpg" width="240">
|

> ### ADVANTAGES & DISADVANTAGES 
1. ### Advantages
    1. Easier to maintain item lists in this app compared to pen-paper.
    2. Easier to tally money spent on each item if we are buying multiple of it as it tells the total cost of the item for the quantity.
2. ### Disadvantages
    1. Currently only supports a single user’s single list.
    2. No authentication so anyone can access the list if they have access to the list.
    3. No categorization or history of past data.

> ### APPLICATIONS 
Right now, this solution can be applied to solve the daily listing problem that maintains the grocery inventory.

> ### CONCLUSION 
This grocery application will help to store the list of data items including name of item, price and quantity required. Admins store his/her data in the list, the grocery application very helpful to users.

> ### FUTURE SCOPE 
This application helps to store the list of items by Admin. In future we can also add scheduled addition of items according to the requirement of the user.
The Features are:
1. Add User Panel
2. Add Admin Panel
3. Provide Login Authentication
4. Add Image to user Product and Rating
5. Provide data syncing between devices
6. History to analyze spending habits
7. Search and find prices for items added on the internet to suggest lower prices and saving money.
8. Note field to add some instructions to be followed while shopping.
