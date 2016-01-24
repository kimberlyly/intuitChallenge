# Intuit Coding Challenge
Hi! I'm Kimberly Ly, and this is my submission to the Intuit Coding challenge.

## Usage
Before beginning, please compile all code by typing `make` into your terminal.

## Question 1
>Sort the following list in numeric order:
>1,10,5,63,29,71,10,12,44,29,10,-1

File: Sort.java

Usage 1: java Sort test - This will run the above test and more.

Usage 2: java Sort n, where n is the number of numbers you would like to add in the array. Then, you will be able to enter numbers in the command line to populate your array.

## Question 2
>Find the 3rd, 58th and 10,001th prime number.

File: PrimeSieve.java

Usage 1: java PrimeSieve test - This will run the above test and more

Usage 2: java PrimeSieve n, where n is the nth prime number you wish to find

## Question 3
> Get full path on an element from the JSON below.  For example the full path of item2 would be /itemList/items[1]/id.
```
{"itemList": {"items": [
    {"id": "item1"},
    {"id": "item2","label": "Item 2"},
    {"id": "item3"},
    {"id": "item4"},
    {"id": "item5"},
    {"id": "subItem1",
        "subItems": [
            {"id": "subItem1Item1","label": "SubItem 1"},
            {"id": "subItem1Item2","label": "SubItem 2"},
            {"id": "subItem1Item3","label": "SubItem 3"}
        ]
    },
    {"id": "item6"},
    {"id": "item7","label": "Item 7"},
    {"id": "subItem2",
        "subItems": {"id": "item1","label": "SubItem 2 item1"}
    }
]}}
```

File: JsonPath.java

Usage: java JsonPath element1 [element2...elementN] - You may enter as many elements as you wish to see their paths, but you must enter at least 1 element.
