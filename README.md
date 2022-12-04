# pollinate_primenumbers

Endpoint: http://localhost:8080/primes/{initial}

Swagger UI:

<img width="861" alt="image" src="https://user-images.githubusercontent.com/71130544/205364982-c41c8003-c9b5-4b0b-8467-603bc6457c9d.png">

If Accept header is set to "application/json", output returned is a json response.

<img width="467" alt="image" src="https://user-images.githubusercontent.com/71130544/205365344-de86962b-aaf8-46ff-b1a4-f9beedc2d15b.png">

If Accept header is set to "application/xml", output returned is an xml response.

<img width="340" alt="image" src="https://user-images.githubusercontent.com/71130544/205365564-15dbe5bb-7e6f-4f8e-9279-f3057149bfb5.png">

Caching:

When tried to fetch prime numbers upto 900000, first hit took more than 400ms and from second hit it is less than 15ms.

First try:

<img width="641" alt="image" src="https://user-images.githubusercontent.com/71130544/205365849-af83cb3e-1057-4391-b8b5-ce99d9d60691.png">

Second try:

<img width="641" alt="image" src="https://user-images.githubusercontent.com/71130544/205366029-d7adb7b3-3a86-44c8-be9d-5f4c2fa909f6.png">


Build Docker image from jar file:

docker build -t primenumbers:latest .

<img width="666" alt="image" src="https://user-images.githubusercontent.com/71130544/205491518-56cdf2e0-2875-4eb5-a0d9-011e72463e03.png">

Run the docker image:

<img width="949" alt="image" src="https://user-images.githubusercontent.com/71130544/205491545-5b52de8a-6e11-4a4f-a632-2e35954e2c36.png">

Docker Desktop:

<img width="953" alt="image" src="https://user-images.githubusercontent.com/71130544/205491607-2aabff1a-ac79-4b52-9cb7-c39eeda4ddba.png">

