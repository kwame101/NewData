# SubwayPass

 You are required to model the following fare card system which is a limited version of New York’s subway card system. At the end of the test, you should be able to demonstrate a user loading a card with $30, and taking the following trips, and then viewing the balance.

- Taking the Subway from 5th to Pelham Parkway
- Taking the 15 bus from Pelham Parkway to Bronx 
- Taking Subway from Pelham Parkway to Guns Hill

The system should favour the customer where more than one fare is possible for a given journey. E.g. 5th to Pelham Parkway is charged at $2.50.

# Stations and zones:
 Station        | Zone(s) <br>
 5th            | 1 <br>
 Pelham Parkway | 1, 2 <br>
 Bronx          | 3 <br>
 Guns Hill      | 2 <br>

# Fares:    <br> 
 Journey                       | Fare <br>
 Anywhere in Zone 1            | $2.50 <br>
 Any one zone outside zone 1   | $2.00 <br>
 Any two zones including zone 1| $3.00 <br>
 Any two zones excluding zone 1| $2.25 <br>
 Any three zones               | $3.20 <br>
 Any bus journey               | $1.80 <br>

 The maximum possible fare is therefore $3.20.

 My solution Using Java <br>
 - Run SysMain main
 
