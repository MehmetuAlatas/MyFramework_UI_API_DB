@pdf
  Feature: Pdf genarator

    Scenario Outline: kullanici datalarini oku ve pdf olustur
      * DB'e baglan "jdbc:postgresql://medunna.com:5432/medunna_db" and "medunnadb_user" , "Medunnadb_@129"
      * pdf olusturmak icin "<query>" yap

      Examples: datalari oku
      |query|
      |Select * from jhi_user|