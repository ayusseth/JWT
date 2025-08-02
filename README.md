# JWT
This project demonstrate JWT Authentication and it is integreted with Swagger UI for documentation of RESTfull API<br>
<h2>Working Flow</h2>
<p>
  <b>POSTMAN</b><br>
  <p>
    In POST method endpoint is <i>/auth/register</i> user enters his/her email & password in JSON format <br>
    Then POSTMAN shows a massage <b><i>User registered successfully</i></b><br>
    In POST method endpoint is <i>/auth/login</i> user enters his/her credential if it is validated from DB then it generate a token <br>
    Paste the token in GET method endpoint is <i>/api/user/me</i> to see the hidden massage<br>
 </p>
 <b>Swagger</b><br>
 <p>
   In <i>/auth/register</i> enter the email & password<br>
   Then in <i>/auth/login</i> enter registered credential then execute<br>
   Then go to <b>Authorize</b> button click and paste the generated token <b>do not use format like <i>Bearer <token-link></i></b><br>
   Then click authorize and go to <i>/api/user/me</i> to see the hidden massage<br>
   Step wise images inSwagger
     <b>Step 1</b> 
     ![image alt](https://github.com/ayusseth/JWT/blob/75ba6eecbe7801a5928b9db077c5c39839a6811f/image_1.png)
     <b>Step 2</b> 
 </p>
</p>
<h2>Folder Responsibility</h2>
<p>
  <b>config</b> -> configure the spring security, JWT filters, exception handeling<br>
  <b>controller</b> -> endpoints likes <i>/auth/register, /auth/login, /user/me</i><br>
  <b>dto</b> -> Clean separation between request/respose objects & entities<br>
  <b>entity</b> -> Contains user model mapped to the DB <br>
  <b>repository</b> -> Interface for DB operation<br>
  <b>service</b> -> Auth logic, register, login, JWT validation<br>
</p>
<h2>Authentication Flow</h2>
<p>
  <b>User Registration</b><br>
  <p>
    POST /auth/register<br>
    Takes email, password <br>
    Saved hashed password (use BCryptPasswordEncoder) in DB<br>
  </p>
  <b>Login</b><br>
  <p>
    POST <i>/auth/login</i><br>
    Validate emial+password<br>
    Generate JWT token using JwtUtils.java if valid<br>
    Return token in AuthResponse.java<br>
  </p>
  <b>Token Usage</b><br>
  <p>
    Client send token in Authorization : Bearer <token> header<br>
    JWT filter extract & validate token<br>
    If valid allow access to protected endpoints<br>
  </p>
</p>

