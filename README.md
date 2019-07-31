Below are the steps for running the airplane rest controller interface

1.) From the main project directory run './gradlew build'. This will create a .jar file in build/libs/.

2.) From the main project directory run 'java -jar build/libs/AirplaneController-0.1.0.jar'. This will start the REST
    controller, which is accessible via localhost:8080.

3.) There are four endpoints exposed by the REST interface, /initialize, /list, /queue, and /dequeue. The /initialize,
    /list and /dequeue endpoints can be hit to perform their respective functions without any additional parameters.
    The /queue endpoint requires two additional url parameters, type and size. These can be passed in a url of the form,

    <http://localhost:8080/queue?type=vip&size=large>

    *Note: The initialize endpoint must be hit to start the queue before any other endpoints will work.