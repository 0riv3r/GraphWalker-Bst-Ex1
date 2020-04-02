The application must have the following API:
============================================

add
---
Desc
    add an integer value
Constraints
    A value is inserted only once
Input
    Integer value
Return
    void

Find
----
Desc
    Find a value in the tree
Input
    Integer value
Return
    Boolean search result
        Found → true
        Not-found → false

Delete
------
Desc
    Delete a leaf
Constraints
    Delete only if this is a leaf
Input
    Integer value
Return
    Boolean result:
        Deleted (found a leaf with that value) → true
        Not deleted (not found or not a leaf) → false

Nodes
-----
Desc
    Return the list of nodes
Return
    Array of all the nodes

IsEmpty
-------
Desc
    Return a boolean value if the tree is empty or not
Return
    Empty → true
    Not Empty → false

largest
-------
Desc
    Return the largest value that is in the tree
Return
    Integer - the largest value that is in the tree

smallest
--------
Desc
    Return the smallest value that is in the tree
Return
    Integer - the smallest value that is in the tree