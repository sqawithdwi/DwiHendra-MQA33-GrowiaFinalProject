
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
      | Dwi Hendra  | dwierp@gmail.com    | Growia1.   | Growia2.       | Error      |

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
      | Dwi Hendra  | dwierp@gmail.com    | Growia1.   | Growia1.       | Error      |

  @negative3
  Scenario Outline: Buyer gagal registrasi karena email salah format
    Given Buyer sudah berada di halaman Sign up
    When Buyer input Nama <name>
    And input Email <email>
    And input password <password>
    And input retype password <retypePassword>
    And klik tombol Sign up
    Then Buyer gagal mendaftar dengan pesan error <statusnok>

    Examples:
      # Invalid email format
      | name        | email              | password   | retypePassword | statusnok  |
      | Dwi Hendra  | dwierp@gmail       | Growia1.   | Growia1.       | Error      |

  @negative4
  Scenario Outline: Buyer gagal registrasi karena password tidak memenuhi kriteria
    Given Buyer sudah berada di halaman Sign up
    When Buyer input Nama <name>
    And input Email <email>
    And input password <password>
    And input retype password <retypePassword>
    And klik tombol Sign up
    Then Buyer gagal mendaftar dengan pesan error <statusnok>

    Examples:
      # Invalid password criteria
      | name        | email              | password   | retypePassword | statusnok  |
      | Dwi Hendra  | dwierp@gmail.com   | growia1.   | growia1.       | Error      |

  @negative5
  Scenario Outline: Buyer gagal registrasi karena password terlalu pendek
    Given Buyer sudah berada di halaman Sign up
    When Buyer input Nama <name>
    And input Email <email>
    And input password <password>
    And input retype password <retypePassword>
    And klik tombol Sign up
    Then Buyer gagal mendaftar dengan pesan error <statusnok>

    Examples:
      # Invalid short password
      | name        | email              | password | retypePassword | statusnok  |
      | Dwi Hendra  | dwierp@gmail.com   | Grow1.   | Grow1.         | Error      |