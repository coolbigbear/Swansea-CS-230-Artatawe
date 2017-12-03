package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.exception.ProfileNotFoundException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Util {
	
	/**
	 * The current user who is signed in to the system.
	 */
	private static Profile currentUser;
	private static Gson gson = new Gson();
	
	public static void readInLoggedInUser(String username) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("JSON Files/Profiles.json"));
			ArrayList<Profile> fromJson = gson.fromJson(br, (Type) Profile.class);
			
			for (Profile profile : fromJson) {
				//Read the variables required for constructor
				String name = profile.getUsername();
				
				if (Objects.equals(name, username)) {
					setCurrentUser(profile);
					return;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		throw new ProfileNotFoundException("Profile not found!");
	}
	
	private static void setCurrentUser(Profile profile) {
		currentUser = new Profile(profile.getUsername(), profile.getFirstName(), profile.getLastName(),
				profile.getPhoneNumber(), profile.getAddressLine1(), profile.getAddressLine2(),
				profile.getCity(), profile.getCountry(), profile.getPostcode(),
				profile.getFavouriteUsers(), profile.getWonAuctions(), profile.getCompletedAuctions(),
				profile.getCurrentlySelling(), profile.getNewAuctions(), profile.getAuctionsNewBids(),
				profile.getAllBidsPlaced(), profile.getLastLogInTime());
	}
	
	//Helper method, could be useful
	public static Profile getProfileByUsername(String username) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("JSON Files/Profiles.json"));
			ArrayList<Profile> allProfiles = gson.fromJson(bufferedReader, (Type) Profile.class);
			
			for (Profile profile : allProfiles) {
				String name = profile.getUsername();
				
				if (Objects.equals(name, username)) {
					return profile;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		throw new ProfileNotFoundException("Profile not found!");
	}
	
	public static void readInAllAuctions() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("JSON Files/Auctions.json"));
			
			RuntimeTypeAdapterFactory<Artwork> artworkAdapterFactory = RuntimeTypeAdapterFactory.of(Artwork.class, "type");
			
			artworkAdapterFactory.registerSubtype(Artwork.class);
			artworkAdapterFactory.registerSubtype(Sculpture.class);
			artworkAdapterFactory.registerSubtype(Painting.class);
			
			Gson gson = new GsonBuilder()
					.registerTypeAdapterFactory(artworkAdapterFactory)
					.create();
			
			Auction[] fromJson = gson.fromJson(br, Auction[].class);
			ArrayList<Auction> auctionArrayList = new ArrayList<>();
			
			for (Auction auction : fromJson) {
				//Read the variables required for constructor
				Artwork artwork = auction.getArtwork();
				Profile seller = auction.getSeller();
				Integer auctionID = auction.getAuctionID();
				List<Bid> bidList = auction.getBidList();
				Double reservePrice = auction.getReservePrice();
				Integer bidsAllowed = auction.getBidsAllowed();
				LocalDateTime dateTimePlaced = auction.getDateTimePlaced();
				Integer bidsLeft = auction.getBidsLeft();
				Profile highestBidder = auction.getHighestBidder();
				Boolean isCompleted = auction.getCompleted();
				Double highestPrice = auction.getHighestPrice();
				
				
				auctionArrayList.add(auction);
				
			}
			BHFeed.getNewInstance().addAll(auctionArrayList);
			System.out.println(BHFeed.getInstance());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void removeFavouriteUser(String usernameToRemove) {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("JSON Files/Profiles.json"));
			ArrayList<Profile> allProfiles = gson.fromJson(bufferedReader, (Type) Profile.class);

			for (Profile profile : allProfiles) {
				String name = profile.getUsername();

//				if (Objects.equals(name, currentUser.getUsername())) {
//					for(Profile profile1 : name)
//					return profile;
//				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static Profile getCurrentUser() {
		return currentUser;
	}
}