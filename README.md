# Ponder Library

This is a Java library which provides interfaces to generically model problem
and solution spaces, as well as strategies for searching the solution space
effectively.


## Function Optimization

Function optimization is a search for a combination of parameters which minimize
or maximize some ordinal quantity (commonly a scalar _score_ or _cost_) assigned
by an objective function.

The two fundamental data types are a point in the _domain_ being searched and
the _result_ returned by objective evaluation. In order to utilize the library
strategies, two classes must be implemented:
* A +Domain+ implementing methods for exploring the search space
* An +Objective+ function to provide evaluation results

In optimization we have:
* some vector of variable inputs x: [ x0, x1, x2, ..., xn ]
* an output value type y (e.g. real number)
* a function which maps inputs to outputs f: x => y
* an ordering on the values of y

The problem is to select values for x which maximize or minimize y. The search
is through the space X and the result (x, y) is the optimal vector x with the
best y value found.


## Function Approximation

Function approximation is the problem of finding a function (f) that
approximates a target function (g), where typically the approximated function
is selected based on a sample of observations (x, also referred to as the
training set) taken from the unknown target function.

In approximation we have:
* some vector of variable inputs x: [ x0, x1, x2, ..., xn ]
* an output value type y
* (x, y) sample observations of an unknown function g

The problem is to find a model f which approximates the function g. Given new
input vector x, the model will predict the output y.


## License

This is free and unencumbered software released into the public domain.
See the UNLICENSE file for more information.
