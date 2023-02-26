BEGIN TRANSACTION;

-- Admin account
INSERT INTO users (username, password_hash, role, is_driver)
VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', 'false');

-- Recyclers
INSERT INTO users (username, password_hash, role, is_driver)
VALUES ('mraymond','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'false'),
       ('bblanc','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'false'),
       ('mbron','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'false'),
       ('ltoussaint','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'false'),
       ('dcody','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'false'),
       ('awingfield','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'false'),
       ('jholden','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'false'),
       ('aburton','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'false'),
       ('nnagata','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'false'),
       ('cmao','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'false'),
       ('cdrummer','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'false'),
       ('fjohnson','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'false'),
       ('kashford','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'false'),
       ('adawes','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'false'),
       ('minaros','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'false');

-- Drivers
INSERT INTO users (username, password_hash, role, is_driver)
VALUES ('lglassmore','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'true'),
       ('mglassmore','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'true'),
       ('cglassmore','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'true');

-- Recycler Details / User Details
INSERT INTO user_details (username, full_name, street_address, city, state_abbreviation, zipcode, phone_number, email_address, total_pounds_recycled, credits_balance, credits_redeemed)
VALUES ('mraymond','Miles Raymond','271 Lelia St', 'Pittsburgh', 'PA','15211','4125551212','mraymond@gmail.com','480','480','0'),
       ('bblanc','Benoit Blanc','220 Luray St', 'Pittsburgh', 'PA','15214','4125551213','bblanc@gmail.com','240','120','120'),
       ('mbron','Miles Bron','2257 Wylie Ave', 'Pittsburgh', 'PA','15219','4125551214','mbron@gmail.com','60','60','0'),
       ('ltoussaint','Lionel Toussaint','1721 Wharton St', 'Pittsburgh', 'PA','15203','4125551215','ltoussaint@gmail.com','100','100','0'),
       ('dcody','Duke Cody','317 Semple St', 'Pittsburgh', 'PA','15213','4125551216','dcody@gmail.com','360','60','300'),
       ('awingfield','Amanda Wingfield','403 Grandview Ave', 'Pittsburgh', 'PA','15211','4125551217','awingfield@gmail.com','480','120','360'),
       ('jholden','James Holden','1207 W North Ave', 'Pittsburgh', 'PA','15233','4125551218','jholden@gmail.com','60','60','0'),
       ('aburton','Amos Burton','812 Beech Ave', 'Pittsburgh', 'PA','15233','4125551219','aburton@gmail.com','180','100','80'),
       ('nnagata','Naomi Nagata','3120 Avalon St', 'Pittsburgh', 'PA','15219','4125551220','nnagata@gmail.com','0','0','0'),
       ('cmao','Clarissa Mao','28 Welsford St', 'Pittsburgh', 'PA','15213','4125551221','cmao@gmail.com','300','120','180'),
       ('cdrummer','Camina Drummer','1031 Herron Ave', 'Pittsburgh', 'PA','15219','4125551222','cdrummer@gmail.com','360','60','300'),
       ('fjohnson','Fred Johnson','300 Heinz St', 'Pittsburgh', 'PA','15212','4125551223','fjohnson@gmail.com','420','60','360'),
       ('kashford','Klaes Ashford','4812 Broad St', 'Pittsburgh', 'PA','15224','4125551224','kashford@gmail.com','480','0','480'),
       ('adawes','Anderson Dawes','715 Ivy St', 'Pittsburgh', 'PA','15232','4125551225','adawes@gmail.com','600','0','600'),
       ('minaros','Marco Inaros','213 Gross St', 'Pittsburgh', 'PA','15224','4125551226','minaros@gmail.com','540','540','0');

-- Driver Details
INSERT INTO driver_details (username,home_office_address)
VALUES ('lglassmore','3001 Railroad St, Pittsburgh, PA 15201'),
       ('mglassmore','3001 Railroad St, Pittsburgh, PA 15201'),
       ('cglassmore','3001 Railroad St, Pittsburgh, PA 15201');

-- Pickup History for mraymond
INSERT INTO routes (route_date)
VALUES ('2022-12-15'),
       ('2022-12-31'),
       ('2023-01-15'),
       ('2023-01-31');
INSERT INTO pickup_details (route_id, requesting_username, pickup_date, pickup_weight, num_of_bins, is_picked_up)
VALUES (1, 'mraymond', '2022-12-15', 120, 2, true),
       (2, 'mraymond', '2022-12-31', 60, 1, true),
       (3, 'mraymond', '2023-01-15', 60, 1, true),
       (4, 'mraymond', '2023-01-31', 180, 3, true);

-- Routes
INSERT INTO routes (route_date)
 VALUES ('2023-02-26'),
        ('2023-02-26'),
        ('2023-02-28'),
        ('2023-02-28');

-- Pickups
INSERT INTO pickup_details (requesting_username, pickup_date, pickup_weight, num_of_bins, is_picked_up)
VALUES ('bblanc', '2023-02-26', 120, 2, false),
       ('mbron', '2023-02-26', 180, 3, false),
       ('ltoussaint', '2023-02-26', 60, 1, false),
       ('dcody', '2023-02-26', 180, 3, false),
       ('awingfield', '2023-02-26', 120, 2, false),
       ('jholden', '2023-02-26', 180, 3, false),
       ('aburton', '2023-02-26', 60, 1, false),
       ('nnagata', '2023-02-26', 120, 2, false),
       ('cmao', '2023-02-28', 180, 3, false),
       ('cdrummer', '2023-02-28', 60, 1, false),
       ('fjohnson', '2023-02-28', 120, 2, false),
       ('kashford', '2023-02-28', 180, 3, false),
       ('adawes', '2023-02-28', 60, 1, false),
       ('minaros', '2023-02-28', 120, 2, false);

-- Prizes
INSERT INTO prize_details (prize_name, point_value)
VALUES ('Vitrum Tshirt', 75),
       ('Donation to Red Cross - Sand Bags for Flood Remediation', 100),
       ('Vitrum Snapback Hat', 150),
       ('$25 Amazon Giftcard', 250),
       ('Local Brewery Tour Experience', 400),
       ('$100 REI Gift Card', 600),
       ('Espresso Machine', 1500),
       ('PlayStation 5 Console', 2500),
       ('Weekend Getaway to 7 Springs Resort', 3750),
       ('Custom Recycled Glass Kitchen Countertop', 5000);

COMMIT TRANSACTION;
