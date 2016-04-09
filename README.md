HelloThrift
===========

An example project on how to make use of Finagle, Zookeeper & Thrift to build scalable backends.

Finagle-HTTP services as REST API

Finagle-Thrift-Zookeeper for the backend service.

Basically you can have N-nodes of finagle-thrift services connecting to Zookeeper for Service Discovery.

Finagle-HTTP uses a client thrift to send requests to thrift service via zookeeper which handles load balancing.

This example project is same as to what i implemented at SiQueries for a Distributed Query Engine on the Cloud BI QuickSense.