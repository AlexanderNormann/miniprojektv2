<!-- Add test data to the database -->

insert into wishlist.users (userID, firstname, lastname, email, password) Values ( "101", "Jonathan", "Andersen", "jonathan.andersen@gmail.com", "1");
insert into wishlist.users (userID, firstname, lastname, email, password) Values ( "102", "Kim", "Pedersen", "pedersen.kim@gmail.com", "1");
insert into wishlist.users (userID, firstname, lastname, email, password) Values ( "103", "Peter", "Nielsen", "peter.nielse@gmail.com", "1");
insert into wishlist.users (userID, firstname, lastname, email, password) Values ( "104", "Emma", "Jacobson", "emma.jacobson@gmail.com", "1");
insert into wishlist.users (userID, firstname, lastname, email, password) Values ( "105", "Johan", "Jepsen", "johan-jepsen@gmail.com", "1");
insert into wishlist.users (userID, firstname, lastname, email, password) Values ( "106", "Emil", "Stengade", "stengadeemil@gmail.com", "1");
insert into wishlist.users (userID, firstname, lastname, email, password) Values ( "107", "Christoffer", "Poulsen", "chris.poulsen@gmail.com", "1");
insert into wishlist.users (userID, firstname, lastname, email, password) Values ( "108", "Jakob", "Reinholdt", "j.reinholdt@gmail.com", "1");
insert into wishlist.users (userID, firstname, lastname, email, password) Values ( "109", "Rikke", "Kayser", "rikke.k@gmail.com", "1");
insert into wishlist.users (userID, firstname, lastname, email, password) Values ( "110", "Niels", "Eugen", "niels.e@gmail.com", "1");



insert into wishlist.product (productid, productname, productsize, productdescription, color, url, price, userID_FK) values ("101", "MacBook", "", "fed mac", "black", "https://www.elgiganten.dk/computer-kontor/computere/barbar-computer/macbook?gclid=CjwKCAiAvriMBhAuEiwA8Cs5lRGM6r4pJTpHE72eV_vOYYildU7TUnJTNbfwexstLBvg1mTFenJbmBoCiKwQAvD_BwE&gclsrc=aw.ds", "7850", "101");
insert into wishlist.product (productid, productname, productsize, productdescription, color, url, price, userID_FK) values ("102", "Iphone", "", "ny telefon", "black", "https://www.telenor.dk/shop/mobil/apple/apple-iphone-13-mini-128gb-midnight/?cid=ps0474340503&gclid=CjwKCAiAvriMBhAuEiwA8Cs5laxcMN9TgyaGJRbaBCljBhVnXtOQsPgVYLKhAH2Bb9OFd3GVLTGnbxoC3_AQAvD_BwE", "5999", "102");
insert into wishlist.product (productid, productname, productsize, productdescription, color, url, price, userID_FK) values ("103", "Vase", "", "til spisebordet", "rød", "https://www.kitchenone.dk/produkt/kaehler-hammershoei-gulvvase-indigoblaa/?shopping_id_click=1067-1092-32631&gclid=CjwKCAiAvriMBhAuEiwA8Cs5leXAzFE_XWTo1ZWDf5w7gfrNbZH1DohsWWGrMRYMygQjcZHtshpv2xoCHDgQAvD_BwE", "1571", "103");
insert into wishlist.product (productid, productname, productsize, productdescription, color, url, price, userID_FK) values ("104", "Kommode", "", "der passer til entre", "hvid", "https://www.lomax.dk/moebler/opbevaringsmoebler/reoler-og-skabe/kontorreoler/budgetline-kommode-m-5-skuffer-hvideg-80063529/?pla=1&gclid=CjwKCAiAvriMBhAuEiwA8Cs5lY3Bun4y04Lhid_Iir71dQuctAONs_GvsjmEG73uTasrzXH-B-GqjRoCnJAQAvD_BwE", "1998", "104");
insert into wishlist.product (productid, productname, productsize, productdescription, color, url, price, userID_FK) values ("105", "Vinglas", "", "nye pinot glas", "", "https://www.georgjensen.com/da-dk/til-bordet/service/sky-roedvinsglas-6-stk./10019206.html?utm_source=google&utm_medium=surfaces&utm_campaign=shopping%20-%20surfaces&gclid=CjwKCAiAvriMBhAuEiwA8Cs5ld6HVkVvXWQBQvv93gObTyaskFKnoIoO6rXXtmhywY4-3solE_wQ5xoCHeQQAvD_BwE", "549", "105");
insert into wishlist.product (productid, productname, productsize, productdescription, color, url, price, userID_FK) values ("106", "Vandkande", "", "til pænt brug", "", "https://www.georgjensen.com/da-dk/til-bordet/kander-karafler/ilse-kande-12-l/3586641.html?utm_source=google&utm_medium=surfaces&utm_campaign=shopping%20-%20surfaces&gclid=CjwKCAiAvriMBhAuEiwA8Cs5lRzg3LAZQcl9eQL3p_9L5CNJjF8nQm-HuxpDdKxu_062e0egbNbx2RoCoD8QAvD_BwE", "1699", "106");
insert into wishlist.product (productid, productname, productsize, productdescription, color, url, price, userID_FK) values ("107", "Sautepande", "", "", "", "https://www.imerco.dk/le-creuset-tns-sauterpande?id=100399976&dfw_tracker=61960-100399976&utm_medium=cpc&utm_source=google&utm_campaign=6536174573&gclid=CjwKCAiAvriMBhAuEiwA8Cs5lQwLcfEcu4bm6FrdPN-91ovtIvIghvYH4SRFg16wC_xvNs42nIIpEBoCi58QAvD_BwE", "749", "107");
insert into wishlist.product (productid, productname, productsize, productdescription, color, url, price, userID_FK) values ("108", "Cykel", "M", "til den nye sæson", "sort og rød", "https://www.jensencykler.com/jensen-cc6-disc-rod-ultegra?gclid=CjwKCAiAvriMBhAuEiwA8Cs5ldh4Sdku90U6eLXdiUY6uhAfBp5hoztlwID10cnJhbHFzUFjxBbWNhoCiboQAvD_BwE", "25000", "108");
insert into wishlist.product (productid, productname, productsize, productdescription, color, url, price, userID_FK) values ("109", "Kuffert", "L", "carrige on til de korte rejser", "sølv", "https://www.rimowa.com/dk/en/luggage/colour/silver/cabin/97353004.html?gclid=CjwKCAiAvriMBhAuEiwA8Cs5lbomhJ-sIOGbPM2f2yGF_DzBQ9G1OSJPAsNkKhOWA_hbD9Tplyx2KRoC0LAQAvD_BwE", "6999", "109");
insert into wishlist.product (productid, productname, productsize, productdescription, color, url, price, userID_FK) values ("110", "Bog om natur", "", "til de ensomme tider", "", "https://www.bog-ide.dk/produkt/3708402/anders-kofoed-anders-kofoeds-store-bog-om-naturen-indbundet/2971237?gclid=CjwKCAiAvriMBhAuEiwA8Cs5lTo2nbrnQv7ZF-faUFmPbON8RRDxzRR5EFk3JkpDlieaFIVtSI3CsBoCMYgQAvD_BwE&gclsrc=aw.ds", "199", "110");