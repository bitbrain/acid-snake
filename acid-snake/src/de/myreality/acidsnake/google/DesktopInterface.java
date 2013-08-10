/* Acid - Provides a Java cell API to display fancy cell boxes.
 * Copyright (C) 2013  Miguel Gonzalez
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 */

package de.myreality.acidsnake.google;

/**
 * Desktop implementation of the google interface
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class DesktopInterface implements GoogleInterface {

	@Override
	public void login() {
		System.out.println("Desktop: would of logged in here");
	}

	@Override
	public void logout() {
		System.out.println("Desktop: would of logged out here");
	}

	@Override
	public boolean getSignedIn() {
		System.out.println("Desktop: getSignIn()");
		return false;
	}

	public void submitScore(int score) {
		System.out.println("Desktop: submitScore: " + score);
	}

	@Override
	public void getScores() {
		System.out.println("Desktop: getScores()");
	}

	@Override
	public void getScoresData() {
		System.out.println("Desktop: getScoresData()");
	}

	@Override
	public void submitArchivement(String id) {
		System.out.println("Archieved: " + id);
	}
}