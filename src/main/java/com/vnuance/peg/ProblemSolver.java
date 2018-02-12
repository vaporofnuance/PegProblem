package com.vnuance.peg;

import java.util.ArrayList;
import java.util.List;

public class ProblemSolver {

	public static class Move {
		public Move(Integer from, Integer remove, Integer to) {
			this.from = from;
			this.remove = remove;
			this.to = to;
		}

		public boolean equals(Move move) {
			return move.from == from && move.to == to && move.remove == remove;
		}

		public String toString() {
			return "Move(from=" + from + " to=" + to + " removing " + remove + ")";
		}

		public final Integer from;
		public final Integer to;
		public final Integer remove;
	}

	private static List<Move> allPossibleMoves;
	private static List<Move> getAllPossibleMoves() {
		if (allPossibleMoves == null) {
			Move[] halfMoves = new Move[] {
				new Move(1, 2, 4),
				new Move(1, 3, 6),
				new Move(2, 4, 7),
				new Move(2, 5, 9),
				new Move(3, 5, 8),
				new Move(3, 6, 10),
				new Move(4, 7, 11),
				new Move(4, 8, 13),
				new Move(4, 5, 6),
				new Move(5, 8, 12),
				new Move(5, 9, 14),
				new Move(6, 9, 13),
				new Move(6, 10, 15),
				new Move(7, 8, 9),
				new Move(8, 9, 10),
				new Move(11, 12, 13),
				new Move(12, 13, 14),
				new Move(13, 14, 15)
			};

			ArrayList<Move> allMovesList = new ArrayList<Move>();
			for (Move halfMove : halfMoves) {
				allMovesList.add(halfMove);
				allMovesList.add(new Move(halfMove.to, halfMove.remove, halfMove.from));
			}

			allPossibleMoves = allMovesList;
		}

		return allPossibleMoves;
	}

	private static boolean isMoveApplicable(List<Integer> state, Move move) {
		return
			getAllPossibleMoves().contains(move) &&
			state.contains(move.from) &&
			state.contains(move.remove) &&
			!state.contains(move.to);
	}

	private static List<Integer> updateState(List<Integer> state, Move move) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.addAll(state);
		if (!isMoveApplicable(state, move)) {
			throw new IllegalArgumentException("Move does not apply to state");
		}

		result.remove(move.from);
		result.remove(move.remove);
		result.add(move.to);

		return result;
	}

	private static List<List<Move>> applyMove(List<Integer> state, List<Move> moves, Move move) {
		List<Move> newMoves = new ArrayList<Move>(moves);
		newMoves.add(move);

		List<Integer> newState = updateState(state, move);

		ArrayList<List<Move>> result = new ArrayList<List<Move>>();
		if (newState.size() == 1) {
			result.add(newMoves);
		} else {
			for (Move possibleMove : getAllPossibleMoves()) {
				if (isMoveApplicable(newState, possibleMove)) {
					result.addAll(applyMove(newState, newMoves, possibleMove));
				}
			}
		}

		return result;
	}

	public static List<List<Move>> solve(int startingPosition) {
		ArrayList<Integer> state = new ArrayList<Integer>();
		for (int i=1; i <= 15; i++) {
			if (i != startingPosition) {
				state.add(i);
			}
		}

		List<List<Move>> answers = new ArrayList<List<Move>>();
		getAllPossibleMoves().
			stream().
			filter(m -> isMoveApplicable(state, m)).
			forEach(m -> {
				answers.addAll(applyMove(state, new ArrayList<Move>(), m));
			});

		return answers;
	}

	public static void main(String args[]) {
		int[] startingPositions = new int[] { 1, 2, 4, 5 };

		for (int startingPosition : startingPositions) {
			System.out.println(solve(startingPosition) + " unique solutions found for starting position " + startingPosition);
		}
	}

}
