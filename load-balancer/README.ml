# Simple Load balancer for student fee system

Simple Load balancer serving user requests to student, fee and payment services

### Building image 

From project root:

`docker build -t 'rakbank-demo/fee-service/nginx:01' load-balancer`

### Running

`docker run --network 'host' rakbank-demo/fee-service/nginx:01`

Available at http://localhost:9000.

Start your requests with `/api/SERVICE-NAME/request`