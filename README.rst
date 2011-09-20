DBTestingSuite
==============

I know that there are several DB benchmarking tools out there but I just wanted to implement my own tool that will help me on my further experiments. I’ve chosen Java as the language since it’s high-level :) and markedly fast with the latest major versions and JREs, and most DB brands have mature Java bindings.

It is abstracted from DB types and brands.

In my definition, types are DB types like Key/Value, Column-Oriented, etc. And brands are DB brands like, Redis, HBase, Tokyo Cabinet etc.

In DBTestingSuite, there are connection interfaces for DB types. For instance, KeyValueConnection interface. Every DB brand will have its connection adapter that implements the connection interface of its type.

And there are threaded and non-threaded test abstracts for different DB types. Every test will extend either the threaded or non-threaded abstract for its DB type according to the nature of the test. For instance, KeyValueCorrectness test uses non-threaded Key/Value test abstract, while KeyValuePerformance test uses threaded Key/Value test abstract.

With this approach, experimenting a new DB brand will be as easy as implementing a DB adapter for it, of course that implements the connection interface of its type. Also different adapters can be easily written for different client libraries or bindings of the same DB brand to be able to test the performances of client libraries. And at the same time, when a new test is written, it will be applicable to all brands in its type.

In order to avoid coupling, since I didn’t use a framework supplying means to bind class types to container classes (`Dependency Injection`_), I manually inject the adapter classes to generic testing class constructors and lower layers use the connections supplied without knowing which kind of connections they are.

.. _Dependency Injection: http://martinfowler.com/articles/injection.html
