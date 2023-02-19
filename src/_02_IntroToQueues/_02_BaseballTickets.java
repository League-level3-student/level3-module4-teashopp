/*
 * Copyright (c) 2020, <GiacomoSorbi> All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE. The views and conclusions contained in the
 * software and documentation are those of the authors and should not be
 * interpreted as representing official policies, either expressed or implied,
 * of the FreeBSD Project.
 */

package _02_IntroToQueues;

import java.util.ArrayDeque;

/*
 * Complete the calculateWaitTime() method here!
 * Instructions are in the BaseBallTicketsTest class.
 */

public class _02_BaseballTickets {

	public static int calculateWaitTime(ArrayDeque<Integer> ticketsQueue, int position) {

		/*
		 * 
		 * 2, 5, 3, 6, 4 ^ 0 5, 3, 6, 4, 1 pos = 4 1, 4, 2, 5, 3 pos = 0 end
		 * 
		 * 0 tix ? pos 0 ?
		 * 
		 */

		// creating
		ArrayDeque<Integer> tix = new ArrayDeque<Integer>();
		int waittime = 0;

		// add to queue
		for (int i = ticketsQueue.size(); i > 0; i--) {
			tix.add(ticketsQueue.pop());
		}

		System.out.println("");
		System.out.println("Original Queue: " + tix);
		System.out.println("-----");

		boolean active = true;

		while (active) {

			// remove and save front of queue
			int removed = tix.remove();

			// subtract 1
			int newtixvalue = removed - 1;

			// +1 wait time
			waittime += 1;

			if (newtixvalue == 0) {

				if (position == 0) {
					System.out.println("Final Wait Time: " + waittime);
					System.out.println("");
					System.out.println("");
					active = false;
				}

			}

			else {
				tix.add(newtixvalue);
				System.out.println("Position: " + position);
				System.out.println("New Queue: " + tix);
				System.out.println("Wait Time: " + waittime);
				System.out.println("-----");
			}

			position -= 1;
			if (position < 0) {
				position = tix.size() - 1;
			}

		}

		return waittime;

	}
}
