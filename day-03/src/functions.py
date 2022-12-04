import math

def find_duplicate_item(inventory):
  length = len(inventory)
  break_index = math.floor(length / 2)
  for i in range(break_index, length):
    item = inventory[i]
    if inventory.index(item) < break_index:
      return item
  return None

def find_common_item(group):
  shortest = min(group, key=len)
  for char in shortest:
    for inventory in group:
      if not inventory.__contains__(char):
        break
    else:
      return char
  return None

def get_item_priority(char):
  charcode = ord(char)
  if charcode >= 65 and charcode <= 90:
    return charcode - 38
  if charcode >= 97 and charcode <= 122:
    return charcode - 96
  return 0

def divide_list(items, batch_size):
  batches = []
  batch = []
  for i in range(0, len(items)):
    batch.append(items[i])
    if len(batch) >= batch_size:
      batches.append(batch)
      batch = []
  return batches

def process_part_1_solution(input_txt):
  rows = input_txt.split('\n')
  current_total = 0

  for row in rows:
    duplicate = find_duplicate_item(row)
    priority = get_item_priority(duplicate)
    current_total += priority

  return current_total

def process_part_2_solution(input_txt):
  rows = input_txt.split('\n')
  groups = divide_list(rows, 3)
  current_total = 0

  for group in groups:
    badge = find_common_item(group)
    priority = get_item_priority(badge)
    current_total += priority

  return current_total