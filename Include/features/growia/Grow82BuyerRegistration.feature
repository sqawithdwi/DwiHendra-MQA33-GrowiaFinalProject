#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@registration
Feature: Buyer Registration
  Sebagai Buyer, Saya ingin bisa mendaftar pada aplikasi Growiashop

  Background:
    Given Buyer sudah berada di halaman Sign up

  @positive
  Scenario Outline: Buyer berhasil registration
    When Buyer input Nama <name>
    And input Email <email>
    And input password <password>
    And input retype password <retypePassword>
    And klik tombol Sign up
    Then Buyer berhasil <statusok> mendaftar

    Examples:
    # Valid registration data
      | name        | email               | password   | retypePassword | statusok |
      | Dwi Hendra  | dwierp@gmail.com    | Growia1.   | Growia1.       | Success  |

  @negative1
  Scenario Outline: Buyer gagal registrasi karena password tidak sesuai
    When Buyer input Nama <name>
    And input Email <email>
    And input password <password>
    And input retype password <retypePassword>
    And klik tombol Sign up
    Then Buyer gagal mendaftar dengan pesan error <statusnok>

    Examples:
    # Invalid retype password
      | name        | email               | password   | retypePassword | statusnok  |
      | Dwi Hendra  | dwierp@gmail.com    | Growia1.   | Growia2.       | Error			 |
      
      
	@negative2
	Scenario Outline: Buyer gagal registrasi karena email sudah terdaftar
  	Given Buyer sudah berada di halaman Sign up
  	When Buyer input Nama <name>
  	And input Email <email>
  	And input password <password>
  	And input retype password <retypePassword>
  	And klik tombol Sign up
  	Then Buyer gagal mendaftar dengan pesan error <statusnok>
  	
  	Examples:
    # Invalid registered email
      | name        | email               | password   | retypePassword | statusnok  |
      | Dwi Hendra  | dwierp@gmail.com    | Growia1.   | Growia1.       | Error			 |
      
  @negative3
	Scenario Outline: Buyer gagal registrasi karena email salah format
  	Given Buyer sudah berada di halaman Sign up
  	When Buyer input Nama <name>
  	And input Email <email1>
  	And input password <password>
  	And input retype password <retypePassword>
  	And klik tombol Sign up
  	Then Buyer gagal mendaftar dengan pesan error <statusnok>
  	
  	Examples:
    # Invalid registered email
      | name        | email1              | password   | retypePassword | statusnok  |
      | Dwi Hendra  | dwierp@gmail		    | Growia1.   | Growia1.       | Error		   |
      
  @negative4
	Scenario Outline: Buyer gagal registrasi karena Password tidak mengandung minimal satu huruf besar, satu special karakter dan satu angka
  	Given Buyer sudah berada di halaman Sign up
  	When Buyer input Nama <name>
  	And input Email <email>
  	And input password <password>
  	And input retype password <retypePassword>
  	And klik tombol Sign up
  	Then Buyer gagal mendaftar dengan pesan error <statusnok>
  	
  	Examples:
    # Invalid registered email
      | name        | email              | password   | retypePassword | statusnok  |
      | Dwi Hendra  | dwierp@gmail.com   | growia1.   | growia1.       | Error		  |
  	
  @negative5
	Scenario Outline: Buyer gagal registrasi karena password kurang dari 8 karakter
  	Given Buyer sudah berada di halaman Sign up
  	When Buyer input Nama <name>
  	And input Email <email>
  	And input password <password>
  	And input retype password <retypePassword>
  	And klik tombol Sign up
  	Then Buyer gagal mendaftar dengan pesan error <statusnok>
  	
  	Examples:
    # Invalid registered email
      | name        | email              | password | retypePassword | statusnok  |
      | Dwi Hendra  | dwierp@gmail.com   | Grow1.   | Grow1.  	     | Error		  |
      