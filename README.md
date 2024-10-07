# Objective

The objective of this workshop is to implement a simple text file database
## Setup
a. Create a branch from day 1 workshop (shopping cart)
## Workshop
Extend day 1 workshop to perform the following. 
The > is the prompt
```
Welcome to your shopping cart
> login fred
fred, your cart is empty
> add apple
apple added to cart
> add orange, pear
orange added to cart
pear added to cart
> list
1. apple
2. orange
3. pear
> save
Your cart has been saved
> login barney
barney, your cart contains the following items
1. coffee
2. sugar
3. biscuits
> add apple
apple added to cart
> list
1. coffee
2. sugar
3. biscuits
4. apple
> save
Your cart has been saved
> users
The following users are registered
1. fred
2. barney
```
### Task 1
Add an option to specify a directory to be used to store user’s shopping cart
eg.
`java shoppingcart.jar cartdb`
where cartdb is a directory to be used to store user’s cart. If the program is
started without specifying the cart database directory, then the program will
default to use a directory called db. If this directory does not exist, create it.
### Task 2
Implement the following additional commands (in addition to those from day 1
workshop)

• `login` - load the specified user’s database file from the shopping cart
directory. If the database file does not exist, create the file. Eg
login fred
will load the file cartdb/fred.db where cartdb is the shopping cart
directory

• `save` - save the contents of the cart to the user’s shopping cart file eg
cartdb/fred.db. If you try to save without first login a particular user,
you should print a message reminding the user to first login as a particular
user.
The save format will be described below.

• `users` - list all users; this is the listing all the filenames under the shopping
cart directory
Create a class called ShoppingCartDB to manage the database; the class
should contain methods like load a shopping cart, save a shopping cart, etc.

### Task 3
You should save the contents of a shopping cart as text file. If fred has the
following items in his cart: apple, orange, pear then his cart will be stored as
follows
```
cartdb/fred.db
apple
orange
Day 03 Workshop Software Development Foundation
pear
```
## Submission
When you have completed your program, merge the feature branch to the
master. Commit and push the master branch to the remote repository.
